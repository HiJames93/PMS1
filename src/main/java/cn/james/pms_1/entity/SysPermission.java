package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    private Integer id;
    private Integer pid;
    private String pType;
    private String percode;
    private String pName;
    private String icon;
    private String href;
    private Integer pOpen;
}
