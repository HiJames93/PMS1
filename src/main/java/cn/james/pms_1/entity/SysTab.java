package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysTab {
    private int tabId;
    private String tabName;
    private String tabMenuType;
    private String tabType;
    private int tabNum;
    private boolean tabOpen;
    private String objectName;
    private String createTime;
    private String lastTime;


    /**
     * 注册选项卡
     * @param tabId
     * @param tabName
     * @param tabMenuType
     * @param tabType
     * @param tabNum
     */
    public SysTab(int tabId, String tabName, String tabMenuType, String tabType, int tabNum) {
        this.tabId = tabId;
        this.tabName = tabName;
        this.tabMenuType = tabMenuType;
        this.tabType = tabType;
        this.tabNum = tabNum;
        this.tabOpen = true;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());;
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());;
    }

    /**
     * 更改选项卡状态
     * @param tabId
     * @param tabOpen
     */
    public SysTab(int tabId, boolean tabOpen) {
        this.tabId = tabId;
        this.tabOpen = tabOpen;
    }

    /**
     * 编辑选项卡
     * @param tabId
     * @param tabName
     * @param tabMenuType
     * @param tabType
     */
    public SysTab(int tabId, String tabName, String tabMenuType, String tabType) {
        this.tabId = tabId;
        this.tabName = tabName;
        this.tabMenuType = tabMenuType;
        this.tabType = tabType;
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}

