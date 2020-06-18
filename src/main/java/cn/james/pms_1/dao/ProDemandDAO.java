package cn.james.pms_1.dao;

import cn.james.pms_1.entity.ProDemand;

import java.util.List;
import java.util.Map;

public interface ProDemandDAO {
    List<ProDemand> selectAll(ProDemand proDemand);
    boolean insertById(ProDemand proDemand);
    boolean updateById(ProDemand proDemand);
    boolean deleteById(int id);

    /**
     * selectDTypeByDId             根据did获取灵感类型
     * updateOpenById               用于改变使能状态
     * selectDemandIdByDemandName   根据名字获取id
     */
    String selectDTypeByDId(int did);
    List<Map> selectDemandNameByDemandOpen();
    int selectDemandIdByDemandName(String demandName);
    boolean updateOpenById(ProDemand proDemand);
    List<Map> selectAllDemandDescByDemandOpen();
}
