package cn.james.pms_1.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
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

    public static final ResultDto UPDATE_DEV_SUCCESS=new ResultDto(3001,"修改设备信息成功");
    public static final ResultDto UPDATE_DEV_FAILURE=new ResultDto(-3001,"修改设备信息失败");

    private int code;
    private String msg;
    private Object data;

    public ResultDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
