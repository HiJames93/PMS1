package cn.james.pms_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProController {

    @RequestMapping("showPM")
    public String showPM(){
        return "sys/pm/proList";
    }

    @RequestMapping("showAddPM")
    public String showAddPM(Model model){

        // 获取所属类型的史诗 -->故事
        // 获取所属类型的故事 -->灵感
        return "sys/pm/addPro";
    }
}
