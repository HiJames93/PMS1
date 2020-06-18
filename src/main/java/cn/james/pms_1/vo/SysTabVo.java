package cn.james.pms_1.vo;

import cn.james.pms_1.entity.SysTab;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysTabVo extends SysTab {
    private Integer page=1;
    private Integer limit=10;
}
