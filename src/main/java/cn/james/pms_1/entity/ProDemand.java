package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProDemand {
    private int demandId;
    private String demandName;
    private String demandDesc;
    private String demandInfo;
    private String ideasSource;
    private String demandType;
    private boolean demandOpen;
    private String createTime;
    private String lastTime;

    /**
     * 新建用
     * @param demandName
     * @param demandDesc
     * @param demandInfo
     * @param ideasSource
     * @param demandType
     */
    public ProDemand(String demandName, String demandDesc, String demandInfo, String ideasSource, String demandType) {
        this.demandName = demandName;
        this.demandDesc = demandDesc;
        this.demandInfo = demandInfo;
        this.ideasSource = ideasSource;
        this.demandType = demandType;
        this.demandOpen = true;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public ProDemand(String dName, boolean dOpen) {
        this.demandName = dName;
        this.demandOpen = dOpen;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public ProDemand(int demandId, String demandName, boolean demandOpen, String lastTime) {
        this.demandId = demandId;
        this.demandName = demandName;
        this.demandOpen = demandOpen;
        this.lastTime = lastTime;
    }
}
