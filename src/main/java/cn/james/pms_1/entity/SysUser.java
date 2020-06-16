package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Integer userId;
    private String userName;
    private boolean useOpen;
}
