package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProManagement {
    private int pid;
    private String pName;
    private String organizerName;
    private String pDesc;
    private String pInfo;
    private String sNum;
    private String dNum;
    private ProStory proStory;
    private ProDemand proDemand;
    private boolean pOpen;
    private Date createTime;

}
