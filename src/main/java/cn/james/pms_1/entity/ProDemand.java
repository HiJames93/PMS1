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
