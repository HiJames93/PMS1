package cn.james.pms_1.controller;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProStory;
import cn.james.pms_1.server.ProDemandServer;
import cn.james.pms_1.server.ProStoryServer;
import cn.james.pms_1.server.SysUserServer;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.ProStoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pro")
public class ProStoryController {

    @Autowired
    private ProStoryServer proStoryServer;
    @Autowired
    private ProDemandServer proDemandServer;
    @Autowired
    private SysUserServer sysUserServer;

    // show故事页
    @RequestMapping("showProStory")
    public String showProStory(){
        return "sys/pm/story/storyIndex";
    }

    // 显示添加故事页
    @RequestMapping("showAddStory.html")
    public String showAddStory(Model model){
        List<Map> userList = sysUserServer.selectAllUserAvailable();
        model.addAttribute("userList",userList);
        return "sys/pm/story/addStory";
    }

    // 显示添加故事页
    @RequestMapping("showUpdateStory.html")
    public String showUpdateStory(Model model){
        List<Map> userList = sysUserServer.selectAllUserAvailable();
        model.addAttribute("userList",userList);
        return "sys/pm/story/editStory";
    }

    // 搜索
    @ResponseBody
    @RequestMapping("/getStoryListByPage")
    public DataGridView getStoryListByPage(ProStoryVo proStoryVo){
        return proStoryServer.getStoryListByPage(proStoryVo);
    }

    // 新建故事
    @ResponseBody
    @RequestMapping("addStory")
    public ResultDto addStory(ProStory proStory){
        // 如果 真 则停用成功
        if (proStoryServer.insertById(proStory)){
            return ResultDto.ADD_STORY_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.ADD_STORY_FAILURE;
    }

    // 编辑故事
    @ResponseBody
    @RequestMapping("updateStory")
    public ResultDto updateStory(ProStory proStory){
        if (proStoryServer.updateById(proStory)){
            return ResultDto.UPDATE_STORY_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.UPDATE_STORY_FAILURE;
    }

    // 启用故事
    @ResponseBody
    @RequestMapping("startStory")
    public ResultDto startStory(ProStory proStory){
        if (proStoryServer.startStory(proStory)){
            return ResultDto.OPEN_STORY_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.OPEN_STORY_FAILURE;
    }
    // 停用故事
    @ResponseBody
    @RequestMapping("stopStory")
    public ResultDto stopStory(ProStory proStory){
        // 如果 真 则停用成功
        if (proStoryServer.stopStory(proStory)){
            return ResultDto.STOP_STORY_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.STOP_STORY_FAILURE;
    }

    // 删除故事
    @ResponseBody
    @RequestMapping("removeStory")
    public ResultDto removeStory(int storyId){
        // 如果 真 则停用成功
        if (proStoryServer.deleteById(storyId)){
            return ResultDto.DELETE_STORY_SUCCESS;
        }
        // 否则 挂了
        return ResultDto.DELETE_STORY_FAILURE;
    }


}
