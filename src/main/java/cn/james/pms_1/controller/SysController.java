package cn.james.pms_1.controller;

import cn.james.pms_1.domain.TreeNode;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.server.ProDemandServer;
import cn.james.pms_1.server.SysPermissionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class SysController {

    @Autowired
    private SysPermissionServer sysPermissionServer;
    @Autowired
    private ProDemandServer proDemandServer;

    // 首页
    @RequestMapping({"","/","index","index.html"})
    public String toIndex(){
        return "index";
    }

    // 404
    @RequestMapping("/gameOver")
    public String gameOver (){
        return "sys/404";
    }

    // main
    @RequestMapping("/showMain")
    public String showMain(Model model){
        List<Map> proDemands = proDemandServer.getAllDemandInfoByDemandOpen();
        model.addAttribute("proDemands",proDemands);
        return "main";
    }

    /**
     * 菜单树
     * @return
     */
    @ResponseBody
    @RequestMapping("/leftMenu")
    public List<TreeNode> loadIndexLeftMenu() {
        List<TreeNode> treeNodes = sysPermissionServer.selectAll();
        return treeNodes;
    }

}




