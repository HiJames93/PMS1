package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.ProDemandDAO;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.server.ProDemandServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProDemandServerImpl implements ProDemandServer {

    @Autowired
    private ProDemandDAO proDemandDAO;

    @Override
    public List<ProDemand> selectAll(ProDemand proDemand) {
        return null;
    }

    @Override
    public boolean insertById(ProDemand proDemand) {
        return false;
    }

    @Override
    public boolean updateById(ProDemand proDemand) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public String selectDTypeByDId(int did) {
        return proDemandDAO.selectDTypeByDId(did);
    }

    @Override
    public int selectDemandNameByDId(String demandName) {
        return proDemandDAO.selectDemandIdByDemandName(demandName);
    }

    @Override
    public List<Map> selectDemandNameByDemandOpen() {
        return proDemandDAO.selectDemandNameByDemandOpen();
    }

    @Override
    public boolean updateOpenById(ProDemand proDemand) {
        return false;
    }
}
