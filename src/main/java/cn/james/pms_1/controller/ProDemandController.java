package cn.james.pms_1.controller;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.server.ProDemandServer;
import cn.james.pms_1.server.SysTabMenuServer;
import cn.james.pms_1.server.SysUserServer;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.ProDemandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("demand")
public class ProDemandController {

    @Autowired
    private SysTabMenuServer sysTabMenuServer;
    @Autowired
    private ProDemandServer proDemandServer;
    @Autowired
    private SysUserServer sysUserServer;

    @RequestMapping("showDemandIndex")
    public String showDemandIndex(Model model){
        List<Map> demandMenuList = sysTabMenuServer.selectAllTabAvailable("demand");
        model.addAttribute("demandMenuList",demandMenuList);
        return "sys/pm/demand/demandIndex";
    }

    @ResponseBody
    @RequestMapping("getDemandListByPage")
    public DataGridView getDemandListByPage(ProDemandVo proDemandVo){
        return proDemandServer.getDemandListByPage(proDemandVo);
    }

    @RequestMapping("showAddDemand.html")
    public String showAddDemand(Model model){
        List<Map> userList = sysUserServer.selectAllUserAvailable();
        model.addAttribute("userList",userList);
        return "sys/pm/demand/addDemand";
    }

    @ResponseBody
    @RequestMapping("addNewDemand")
    public ResultDto addNewDemand(ProDemand proDemand){
        return proDemandServer.insertById(proDemand);
    }

}
