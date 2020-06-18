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
    public static final ResultDto STOP_TAB_SUCCESS=new ResultDto(3006,"成功停用选项卡");
    public static final ResultDto STOP_TAB_FAILURE=new ResultDto(-3006,"停用选项卡失败");
    public static final ResultDto OPEN_TAB_SUCCESS=new ResultDto(3007,"启用选项卡成功");
    public static final ResultDto OPEN_TAB_FAILURE=new ResultDto(-3007,"启用选项卡失败");

    // 史诗
    public static final ResultDto ADD_DEMAND_SUCCESS=new ResultDto(3001,"添加成功");
    public static final ResultDto ADD_DEMAND_FAILURE=new ResultDto(-3001,"添加失败");
    public static final ResultDto DELETE_DEMAND_SUCCESS=new ResultDto(3002,"删除史诗成功");
    public static final ResultDto DELETE_DEMAND_FAILURE=new ResultDto(-3002,"删除史诗失败");
    public static final ResultDto DEMAND_EXITS=new ResultDto(-3040,"史诗已存在");
    public static final ResultDto UPDATE_DEMAND_SUCCESS=new ResultDto(3005,"更新史诗信息成功");
    public static final ResultDto UPDATE_DEMAND_FAILURE=new ResultDto(-3005,"更新史诗信息失败");
    public static final ResultDto STOP_DEMAND_SUCCESS=new ResultDto(3006,"成功停用史诗");
    public static final ResultDto STOP_DEMAND_FAILURE=new ResultDto(-3006,"停用史诗失败");
    public static final ResultDto OPEN_DEMAND_SUCCESS=new ResultDto(3007,"启用史诗成功");
    public static final ResultDto OPEN_DEMAND_FAILURE=new ResultDto(-3007,"启用史诗失败");

    private int code;
    private String msg;
    private Object data;

    public ResultDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
