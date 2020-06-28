package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * @Title: ProManagement
 * @Description: 项目管理
 * @param:
 * @return:
 * @date: 6/24/20 1:13 PM
 * @throws
 **/
public class ProManagement {
    // id
    private Integer pro_id;
    // 名称
    private String pro_name;
    //发起人
    private String pro_organizerName;
    // 简介
    private String pro_desc;
    // 详情
    private String pro_info;
    // 项目类型
    private String pro_type;
    // 史诗列表
    private List<ProDemand> demands;
    // 启用状态
    private Boolean pro_open;
    // 初始化时间
    private Date pro_createTime;
    // 修改时间
    private Date pro_lastTime;

}
