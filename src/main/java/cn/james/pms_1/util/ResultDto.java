package cn.james.pms_1.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {

    // 用户故事
    public static final ResultDto ADD_STORY_SUCCESS=new ResultDto(1004,"添加故事成功");
    public static final ResultDto ADD_STORY_FAILURE=new ResultDto(-1004,"添加故事失败");
    public static final ResultDto DELETE_STORY_SUCCESS=new ResultDto(1002,"删除故事成功");
    public static final ResultDto DELETE_STORY_FAILURE=new ResultDto(-1002,"删除故事失败");
    public static final ResultDto STORY_EXITS=new ResultDto(-1040,"故事已存在");
    public static final ResultDto UPDATE_STORY_SUCCESS=new ResultDto(3005,"更新故事信息成功");
    public static final ResultDto UPDATE_STORY_FAILURE=new ResultDto(-3005,"更新故事信息失败");
    public static final ResultDto STOP_STORY_SUCCESS=new ResultDto(2001,"成功停用此功能");
    public static final ResultDto STOP_STORY_FAILURE=new ResultDto(-2001,"停用此故事失败");
    public static final ResultDto OPEN_STORY_SUCCESS=new ResultDto(2002,"启用此故事成功");
    public static final ResultDto OPEN_STORY_FAILURE=new ResultDto(-2002,"启用此故事失败");

    // 选项卡
    public static final ResultDto ADD_TAB_SUCCESS=new ResultDto(3001,"注册成功");
    public static final ResultDto ADD_TAB_FAILURE=new ResultDto(-3001,"注册失败");
    public static final ResultDto DELETE_TAB_SUCCESS=new ResultDto(3002,"删除选项卡成功");
    public static final ResultDto DELETE_TAB_FAILURE=new ResultDto(-3002,"删除选项卡失败");
    public static final ResultDto TAB_EXITS=new ResultDto(-3040,"选项卡已存在");
    public static final ResultDto UPDATE_TAB_SUCCESS=new ResultDto(3005,"更新选项卡信息成功");
    public static final ResultDto UPDATE_TAB_FAILURE=new ResultDto(-3005,"更新选项卡信息失败");
    public static final ResultDto STOP_TAB_SUCCESS=new ResultDto(3006,"停用成功");
    public static final ResultDto STOP_TAB_FAILURE=new ResultDto(-3006,"停用失败");
    public static final ResultDto OPEN_TAB_SUCCESS=new ResultDto(3007,"启用成功");
    public static final ResultDto OPEN_TAB_FAILURE=new ResultDto(-3007,"启用失败");

    // 史诗
    public static final ResultDto ADD_DEMAND_SUCCESS=new ResultDto(4001,"添加成功");
    public static final ResultDto ADD_DEMAND_FAILURE=new ResultDto(-4001,"添加失败");
    public static final ResultDto DELETE_DEMAND_SUCCESS=new ResultDto(4002,"删除史诗成功");
    public static final ResultDto DELETE_DEMAND_FAILURE=new ResultDto(-4002,"删除史诗失败");
    public static final ResultDto DEMAND_EXITS=new ResultDto(-4040,"史诗已存在");
    public static final ResultDto UPDATE_DEMAND_SUCCESS=new ResultDto(4005,"更新史诗成功");
    public static final ResultDto UPDATE_DEMAND_FAILURE=new ResultDto(-4005,"更新史诗失败");
    public static final ResultDto OPEN_DEMAND_SUCCESS=new ResultDto(4006,"启用成功");
    public static final ResultDto OPEN_DEMAND_FAILURE=new ResultDto(-4006,"启用失败");
    public static final ResultDto STOP_DEMAND_SUCCESS=new ResultDto(4007,"停用成功");
    public static final ResultDto STOP_DEMAND_FAILURE=new ResultDto(-4007,"停用失败");

    // 认领
    public static final ResultDto ADD_CLAIM_SUCCESS=new ResultDto(6001,"认领成功");
    public static final ResultDto ADD_CLAIM_FAILURE=new ResultDto(-6001,"认领失败");
    public static final ResultDto DELETE_CLAIM_SUCCESS=new ResultDto(6002,"删除成功");
    public static final ResultDto DELETE_CLAIM_FAILURE=new ResultDto(-6002,"删除失败");
    public static final ResultDto CLAIM_EXITS=new ResultDto(-6040,"已认领");
    public static final ResultDto UPDATE_CLAIM_SUCCESS=new ResultDto(6005,"更新成功");
    public static final ResultDto UPDATE_CLAIM_FAILURE=new ResultDto(-6005,"更新失败");



    private int code;
    private String msg;
    private Object data;

    public ResultDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
