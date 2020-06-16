package cn.james.pms_1.controller;

import cn.james.pms_1.domain.TreeNode;
import cn.james.pms_1.server.SySPermissionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysController {

    @Autowired
    private SySPermissionServer sysPermissionServer;

    // 首页
    @RequestMapping({"","/","index","index.html"})
    public String toIndex(){
        return "index";
    }

    // 左边菜单
    @RequestMapping("/baseDevList")
    public String baseDevList(){
        return "sys/dev/devList";
    }

    // 设备监控
    @RequestMapping("/monitorIndex")
    public String monitorIndex(){
        return "sys/dev/monitor/monitorIndex";
    }

    // 功能中心
    @RequestMapping("/featuresIndex")
    public String featuresIndex(){
        return "sys/features/featuresIndex";
    }

    // 404
    @RequestMapping("/gameOver")
    public String gameOver (){
        return "sys/404";
    }

    // main
    @RequestMapping("/showMain")
    public String showMain(){
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




