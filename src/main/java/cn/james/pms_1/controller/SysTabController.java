package cn.james.pms_1.controller;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.SysTab;
import cn.james.pms_1.server.SysTabMenuServer;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.SysTabVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("tabMenu")
public class SysTabController {

    @Autowired
    private SysTabMenuServer sysTabMenuServer;

    /**
     * show选项卡管理页
     * @return
     */
    @RequestMapping("showTabMenu")
    public String showTabMenu(){
        return "sys/tab/tabIndex";
    }

    /**
     * 显示添加故事页
     * @param model
     * @return
     */
    @RequestMapping("showAddTabMenu.html")
    public String showAddTabMenu(Model model){
        List<Map> tabTypeList = sysTabMenuServer.getAllTabType();

        model.addAttribute("tabTypeList",tabTypeList);
        return "sys/tab/addTab";
    }

    /**
     * 显示注册故事页
     * @param model
     * @return
     */
    @RequestMapping("showEditTabMenu.html")
    public String showEditTabMenu(Model model){
        return "sys/tab/editTab";
    }

    /**
     * 搜索
     * @param sysTabMenuVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTabMenuListByPage")
    public DataGridView getTabMenuListByPage(SysTabVo sysTabMenuVo){
        return sysTabMenuServer.getTabMenuListByPage(sysTabMenuVo);
    }

    /**
     * 注册故事
     * @param sysTab
     * @return
     */
    @ResponseBody
    @RequestMapping("addTab")
    public ResultDto addTab(SysTab sysTab){
        // 如果 真 则注册成功
        if (sysTabMenuServer.insertById(sysTab)){
            return ResultDto.ADD_TAB_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.ADD_TAB_FAILURE;
    }

    /**
     * 编辑故事
     * @param sysTab
     * @return
     */
    @ResponseBody
    @RequestMapping("updateTab")
    public ResultDto updateTab(SysTab sysTab){
        if (sysTabMenuServer.updateById(sysTab)){
            return ResultDto.UPDATE_TAB_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.UPDATE_TAB_FAILURE;
    }

    /**
     * 启用故事
     * @param sysTab
     * @return
     */
    @ResponseBody
    @RequestMapping("startTab")
    public ResultDto startTab(SysTab sysTab){
        if (sysTabMenuServer.startTab(sysTab)){
            return ResultDto.OPEN_TAB_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.OPEN_TAB_FAILURE;
    }
    // 停用故事
    @ResponseBody
    @RequestMapping("stopTab")
    public ResultDto stopTab(SysTab sysTab){
        // 如果 真 则停用成功
        if (sysTabMenuServer.stopTab(sysTab)){
            return ResultDto.STOP_TAB_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.STOP_TAB_FAILURE;
    }

    // 删除故事
    @ResponseBody
    @RequestMapping("removeTab")
    public ResultDto removeTab(int tabId){
        // 如果 真 则停用成功
        if (sysTabMenuServer.deleteById(tabId)){
            return ResultDto.DELETE_TAB_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.DELETE_TAB_FAILURE;
    }
}
