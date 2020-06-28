package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    private Integer id;
    private Integer permissionId;
    private String permissionType;
    private String percode;
    private String permissionName;
    private String icon;
    private String href;
    private Integer permissionOpen;
}
