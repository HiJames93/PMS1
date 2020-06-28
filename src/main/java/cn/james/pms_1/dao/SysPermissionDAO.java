package cn.james.pms_1.dao;



import cn.james.pms_1.entity.SysPermission;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysPermissionDAO {
    List<SysPermission> selectAll();
}
