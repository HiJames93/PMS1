package cn.james.pms_1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@NoArgsConstructor
public class ProStory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer story_id;
    private String story_name;
    private String user_name;
    private String story_desc;
    private String story_info;
    private String story_ideasSource;
    private String story_type;
    private Boolean story_open;
    private String createTime;
    private String lastTime;

    /**
     * 更改故事状态
     * @param sid
     * @param sOpen
     */
    public ProStory(int sid, boolean sOpen) {
        this.story_id = sid;
        this.story_open = sOpen;
    }

    /**
     * @Title: ProStory
     * @Description: 新建项目
     * @param: [story_name, user_name, story_desc, story_info, story_ideasSource]
     * @return:
     * @date: 6/26/20 11:30 PM
     * @throws
     **/
    public ProStory(String story_name, String user_name, String story_desc, String story_info, String story_ideasSource) {
        this.story_name = story_name;
        this.user_name = user_name;
        this.story_desc = story_desc;
        this.story_info = story_info;
        this.story_ideasSource = story_ideasSource;
        this.story_open = true;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public ProStory(String story_name, String user_name, String story_desc, String story_info, boolean story_open) {
        this.story_name = story_name;
        this.user_name = user_name;
        this.story_desc = story_desc;
        this.story_info = story_info;
        this.story_open = story_open;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public ProStory(String story_name, String user_name, String story_desc, String story_info, String story_ideasSource, boolean story_open) {
        this.story_name = story_name;
        this.user_name = user_name;
        this.story_desc = story_desc;
        this.story_info = story_info;
        this.story_ideasSource = story_ideasSource;
        this.story_open = story_open;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }


    /**
     * @Title: ProStory
     * @Description: 更新用
     * @param: [story_id, story_name, user_name, story_desc, story_info, story_ideasSource, story_type]
     * @return:
     * @date: 6/27/20 12:05 AM
     * @throws
     **/
    public ProStory(Integer story_id, String story_name, String user_name, String story_desc, String story_info, String story_ideasSource, String story_type) {
        this.story_id = story_id;
        this.story_name = story_name;
        this.user_name = user_name;
        this.story_desc = story_desc;
        this.story_info = story_info;
        this.story_ideasSource = story_ideasSource;
        this.story_type = story_type;
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}
