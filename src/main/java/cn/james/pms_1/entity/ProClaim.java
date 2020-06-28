package cn.james.pms_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: ProClaim
 * @Desciption: 任务领取情况
 * @author: James
 * @date: 2020-06-28 5:23 PM
 * @version: 1.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProClaim {
    private Integer claim_id;
    private String claim_title;
    private Integer pro_id;
    private Integer demand_id;
    private Integer story_id;
    private Integer user_id;
    private Boolean claim_type;
    private String claim_createtime;
    private String claim_lasttime;

    /**
     * @Title: ProClaim
     * @Description: 添加一条认领
     * @param:  1.claim_title: 根据ID获取名称,
     *          2.pro_id: 获取项目ID,
     *          3.demand_id：获取史诗ID,
     *          3.story_id：获取故事ID,
     *          4.user_id：获取认领人ID,
     *          5.claim_type: 初始化默认 true
     * @return:
     * @date: 6/28/20 5:28 PM
     * @throws
     **/
    public ProClaim(String claim_title, Integer pro_id, Integer demand_id, Integer story_id, Integer user_id, Boolean claim_type) {
        this.claim_title = claim_title;
        this.pro_id = pro_id;
        this.demand_id = demand_id;
        this.story_id = story_id;
        this.user_id = user_id;
        this.claim_type = claim_type;
        this.claim_createtime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.claim_lasttime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * @Title: ProClaim
     * @Description: 修改认领人
     * @param: 1.user_id：读取user表 获取用户列表,
     * @return:
     * @date: 6/28/20 5:33 PM
     * @throws
     **/
    public ProClaim(Integer claim_id, Integer user_id) {
        this.claim_id = claim_id;
        this.user_id = user_id;
        this.claim_lasttime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * @Title: ProClaim
     * @Description: 解除认领 根据ID 修改type状态
     * @param: [claim_id]
     * @return:
     * @date: 6/28/20 5:44 PM
     * @throws
     **/
    public ProClaim(Integer claim_id) {
        this.claim_id = claim_id;
        this.claim_type = false;
        this.claim_lasttime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}
