package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProDemand {
    private int demand_id;
    private String demand_name;
    private String user_name;
    private String demand_desc;
    private String demand_info;
    private String demand_ideasSource;
    private String demand_type;
    private boolean demand_open;
    private String createTime;
    private String lastTime;

    /**
     * @Title: ProDemand
     * @Description: 新建用
     * @param: [demand_name, user_name, demand_desc, demand_info, demand_ideasSource, demand_type]
     * @return:
     * @date: 6/26/20 8:17 PM
     * @throws
     **/
    public ProDemand(String demand_name, String user_name, String demand_desc, String demand_info, String demand_ideasSource, String demand_type) {
        this.demand_name = demand_name;
        this.user_name = user_name;
        this.demand_desc = demand_desc;
        this.demand_info = demand_info;
        this.demand_ideasSource = demand_ideasSource;
        this.demand_type = demand_type;
        this.demand_open = false;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * @Title: ProDemand
     * @Description: 状态更新用
     * @param: [demand_id, demand_open]
     * @return:
     * @date: 6/26/20 8:18 PM
     * @throws
     **/
    public ProDemand(int demand_id, boolean demand_open) {
        this.demand_id = demand_id;
        this.demand_open = demand_open;
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * @Title: ProDemand
     * @Description: 修改用
     * @param: [demand_id, demand_name, user_name, demand_desc, demand_info, demand_ideasSource, demand_type]
     * @return:
     * @date: 6/27/20 12:10 AM
     * @throws
     **/
    public ProDemand(int demand_id, String demand_name, String user_name, String demand_desc, String demand_info, String demand_ideasSource, String demand_type) {
        this.demand_id = demand_id;
        this.demand_name = demand_name;
        this.user_name = user_name;
        this.demand_desc = demand_desc;
        this.demand_info = demand_info;
        this.demand_ideasSource = demand_ideasSource;
        this.demand_type = demand_type;
        this.lastTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}
