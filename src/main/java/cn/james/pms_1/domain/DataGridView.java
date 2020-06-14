package cn.james.pms_1.domain;

import lombok.Data;

@Data
public class DataGridView {
    private Integer code=0;
    private String msg="";
    private Long count;
    private Object data;

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public DataGridView(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
