package cn.james.pms_1.vo;

import cn.james.pms_1.entity.ProManagement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ProManagementVo
 * @Desciption:
 * @author: James
 * @date: 2020-06-28 9:38 AM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProManagementVo extends ProManagement {
    private Integer page=1;
    private Integer limit=10;
}
