package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.SysUserDAO;
import cn.james.pms_1.server.SysUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysUserServerImpl implements SysUserServer {

    @Autowired
    private SysUserDAO sysUserDAO;

    @Override
    public List<Map> selectAllUserAvailable() {
        return sysUserDAO.selectAllUserAvailable();
    }
}
