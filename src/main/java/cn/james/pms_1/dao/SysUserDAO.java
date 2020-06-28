package cn.james.pms_1.dao;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SysUserDAO {

    List<Map> selectAllUserAvailable();
}
