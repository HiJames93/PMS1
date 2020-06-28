package cn.james.pms_1.controller;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.server.ProManagementService;
import cn.james.pms_1.vo.ProManagementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ProManagementController
 * @Desciption:
 * @author: James
 * @date: 2020-06-28 10:24 AM
 * @version: 1.0
 */

@Controller
@RequestMapping("pro")
public class ProManagementController {

    @Autowired
    private ProManagementService proManagementService;

    @RequestMapping({"index","index.html"})
    public String showIndex(){
        return "sys/pm/proList";
    }

    @ResponseBody
    @RequestMapping("getList.html")
    public DataGridView getList(ProManagementVo proManagementVo){
        return proManagementService.getProListByPage(proManagementVo);
    }
}
