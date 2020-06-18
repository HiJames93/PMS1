package cn.james.pms_1.server;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.ProDemandVo;

import java.util.List;
import java.util.Map;

public interface ProDemandServer {
    DataGridView getDemandListByPage(ProDemandVo proDemandVo);
    ResultDto insertById(ProDemand proDemand);
    ResultDto updateById(ProDemand proDemand);
    ResultDto deleteById(int id);

    /**
     * selectDTypeByDId                 根据did获取灵感类型
     * selectDemandNameByDemandOpen     根据灵感ID获取灵感名称
     * updateOpenById                   用于改变使能状态
     */
    String selectDTypeByDId(int did);
    int selectDemandNameByDId(String demandName);
    List<Map> selectDemandNameByDemandOpen();
    boolean updateOpenById(ProDemand proDemand);
    List<Map> getAllDemandInfoByDemandOpen();
}
