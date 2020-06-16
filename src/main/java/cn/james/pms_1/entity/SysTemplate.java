package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysTemplate {
    private String tid;
    private String tName;
    private String tDesc;
    private String tAuthor;
    private String tImgPath;
    private String tAttributes;
    private ProManagement proManagement;
    private String createTime;
}
