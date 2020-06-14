package cn.james.pms_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProController {

    @RequestMapping("showPM")
    public String showPM(){
        return "sys/pm/proList";
    }
}
