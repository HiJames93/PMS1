package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@NoArgsConstructor
public class ProStory {
    private int storyId;
    private String storyName;
    private int userId;
    private String storyDesc;
    private String storyInfo;
    private String ideasSource;
    private boolean storyOpen;
    private String createTime;
    private String lastTime;

    public ProStory(int sid, boolean sOpen) {
        this.storyId = sid;
        this.storyOpen = sOpen;
    }

    /**
     * 新建项目
      * @param storyName
     * @param userId
     * @param storyDesc
     * @param storyInfo
     * @param ideasSource
     */
    public ProStory(String storyName, int userId, String storyDesc, String storyInfo, String ideasSource) {
        this.storyName = storyName;
        this.userId = userId;
        this.storyDesc = storyDesc;
        this.storyInfo = storyInfo;
        this.ideasSource = ideasSource;
        this.storyOpen = true;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public ProStory(String sName, int userId, String sDesc, String sInfo, boolean sOpen) {
        this.storyName = sName;
        this.userId = userId;
        this.storyDesc = sDesc;
        this.storyInfo = sInfo;
        this.storyOpen = sOpen;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public ProStory(String sName, int userId, String sDesc, String sInfo, String ideasSource, boolean sOpen) {
        this.storyName = sName;
        this.userId = userId;
        this.storyDesc = sDesc;
        this.storyInfo = sInfo;
        this.ideasSource = ideasSource;
        this.storyOpen = sOpen;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }


    /**
     * 更新用
     * @param sid
     * @param storyName
     * @param userId
     * @param storyDesc
     * @param storyInfo
     * @param ideasSource
     */
    public ProStory(int sid, String storyName, int userId, String storyDesc, String storyInfo, String ideasSource) {
        this.storyId = sid;
        this.storyName = storyName;
        this.userId = userId;
        this.storyDesc = storyDesc;
        this.storyInfo = storyInfo;
        this.ideasSource = ideasSource;
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}
