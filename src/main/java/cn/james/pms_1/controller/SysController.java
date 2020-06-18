package cn.james.pms_1.controller;

import cn.james.pms_1.domain.TreeNode;
import cn.james.pms_1.server.ProDemandServer;
import cn.james.pms_1.server.SySPermissionServer;
import cn.james.pms_1.server.SysTabMenuServer;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    private SySPermissionServer sysPermissionServer;
    @Autowired
    private SysTabMenuServer sysTabMenuServer;
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
        List<Map> demandList = proDemandServer.getAllDemandInfoByDemandOpen();
        List<Map> tabMenuList = sysTabMenuServer.selectAllTabAvailable("main");
        model.addAttribute("tabMenuList",tabMenuList);
        model.addAttribute("demandList",demandList);
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




