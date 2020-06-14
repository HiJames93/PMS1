package cn.james.pms_1.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    public static final ResultDto ADD_FEATURES_SUCCESS=new ResultDto(1004,"添加功能成功");
    public static final ResultDto ADD_FEATURES_FAILURE=new ResultDto(-1004,"添加功能失败");
    public static ResultDto DELETE_FEATURES_SUCCESS=new ResultDto(1002,"删除功能成功");
    public static ResultDto DELETE_FEATURES_FAILURE=new ResultDto(-1002,"删除功能失败");
    public static ResultDto FEATURES_EXITS=new ResultDto(-1040,"功能已存在");
    public static final ResultDto UPDATE_FEATURES_SUCCESS=new ResultDto(3005,"更新功能信息成功");
    public static final ResultDto UPDATE_FEATURES_FAILURE=new ResultDto(-3005,"更新功能信息失败");
    public static ResultDto STOP_FEATURES_SUCCESS=new ResultDto(2001,"成功停用此功能");
    public static ResultDto STOP_FEATURES_FAILURE=new ResultDto(-2001,"停用此功能失败");
    public static ResultDto OPEN_FEATURES_SUCCESS=new ResultDto(2002,"启用此功能成功");
    public static ResultDto OPEN_FEATURES_FAILURE=new ResultDto(-2002,"启用此功能失败");

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
