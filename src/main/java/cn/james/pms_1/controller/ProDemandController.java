package cn.james.pms_1.controller;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.server.ProDemandServer;
import cn.james.pms_1.server.SysUserServer;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.ProDemandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("demand")
public class ProDemandController {

    @Autowired
    private ProDemandServer proDemandServer;
    @Autowired
    private SysUserServer sysUserServer;

    /**
     * @Title: showDemandIndex
     * @Description: 显示史诗中心主页
     * @param: []
     * @return: java.lang.String
     * @date: 6/28/20 3:24 PM
     * @throws
     **/
    @RequestMapping("showDemandIndex")
    public String showDemandIndex(){
        return "sys/pm/demand/demandIndex";
    }

    /**
     * @Title: getDemandListByPage
     * @Description: 加载史诗列表，不管是否启用都显示出来
     * @param: [proDemandVo]
     * @return: cn.james.pms_1.domain.DataGridView
     * @date: 6/28/20 3:24 PM
     * @throws
     **/
    @ResponseBody
    @RequestMapping("getDemandListByPage")
    public DataGridView getDemandListByPage(ProDemandVo proDemandVo){
        return proDemandServer.getDemandListByPage(proDemandVo);
    }

    /**
     * @Title: showAddDemand
     * @Description: 显示添加页面
     * @param: [model]
     * @return: java.lang.String
     * @date: 6/28/20 3:22 PM
     * @throws
     **/
    @RequestMapping("showAddDemand.html")
    public String showAddDemand(Model model){
        List<Map> userList = sysUserServer.selectAllUserAvailable();
        model.addAttribute("userList",userList);
        return "sys/pm/demand/addDemand";
    }

    /**
     * @Title: showUpdateDemand
     * @Description: 显示更新页面
     * @param: [model]
     * @return: java.lang.String
     * @date: 6/28/20 3:22 PM
     * @throws
     **/
    @RequestMapping("showUpdateDemand.html")
    public String showUpdateDemand(Model model){
        List<Map> userList = sysUserServer.selectAllUserAvailable();
        model.addAttribute("userList",userList);
        return "sys/pm/demand/editDemand";
    }

    /**
     * @Title: addNewDemand
     * @Description: 执行添加方法
     * @param: [proDemand]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/28/20 3:22 PM
     * @throws
     **/
    @ResponseBody
    @RequestMapping("addNewDemand")
    public ResultDto addNewDemand(ProDemand proDemand){
        return proDemandServer.insertById(proDemand);
    }

    /**
     * @Title: updateDemand
     * @Description: 执行更新方法
     * @param: [proDemand]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/28/20 3:22 PM
     * @throws
     **/
    @ResponseBody
    @RequestMapping("updateDemand")
    public ResultDto updateDemand(ProDemand proDemand){
        return proDemandServer.updateById(proDemand);
    }

    /**
     * @Title: stopDemand
     * @Description: 执行停用方法
     * @param: [proDemand]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/28/20 3:22 PM
     * @throws
     **/
    @ResponseBody
    @RequestMapping("stopDemand")
    public ResultDto stopDemand(ProDemand proDemand){
        return proDemandServer.updateStopById(proDemand);
    }

    /**
     * @Title: startDemand
     * @Description: 执行启用方法
     * @param: [proDemand]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/28/20 3:23 PM
     * @throws
     **/
    @ResponseBody
    @RequestMapping("startDemand")
    public ResultDto startDemand(ProDemand proDemand){
        return proDemandServer.updateOpenById(proDemand);
    }

    /**
     * @Title: removeDemand
     * @Description: 删除史诗
     * @param: [demandId]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/28/20 3:23 PM
     * @throws
     **/
    @ResponseBody
    @RequestMapping("removeDemand")
    public ResultDto removeDemand(int demandId){
        return proDemandServer.deleteById(demandId);
    }

/******************************************************************************************************
 *
 *                                           统计 & 显示
 *
 ******************************************************************************************************/
    @ResponseBody
    @RequestMapping("toDemandTypeListsInfo")
    public Map<String, List<Map<String,Integer>>> toDemandTypeListsInfo(){
        Map<String, List<Map<String,Integer>>> otherSysPie1 = new HashMap<>();
        List<Map<String,Integer>> list1 = proDemandServer.getDemandNameAndQuantity();
        otherSysPie1.put("data_pie",list1);
        return otherSysPie1;
    }

}
