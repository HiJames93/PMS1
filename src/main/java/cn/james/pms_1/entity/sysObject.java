package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: sysObject
 * @Desciption:
 * @author: James
 * @date: 2020-06-28 11:18 AM
 * @version: 1.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class sysObject {
    private Integer object_id;
    private String object_title;
    private String object_info;
    private Date object_createTime;
    private Date object_lastTime;
}
