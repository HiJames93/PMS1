package cn.james.pms_1.server;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.ProDemandVo;

import java.util.List;
import java.util.Map;

public interface ProDemandServer {
    /**
     * @Title: getDemandListByPage
     * @Description: 分页全查询
     * @param: [proDemandVo]
     * @return: cn.james.pms_1.domain.DataGridView
     * @date: 6/27/20 12:17 AM
     * @throws
     **/
    DataGridView getDemandListByPage(ProDemandVo proDemandVo);
    ResultDto insertById(ProDemand proDemand);
    ResultDto updateById(ProDemand proDemand);
    ResultDto deleteById(int demandId);

    /**
     * selectDemandNameByDemandOpen     根据灵感ID获取灵感名称
     * updateOpenById                   用于改变使能状态 -> 启用
     * updateStopById                   用于改变使能状态 -> 弃用
     * getAllDemandInfoByDemandOpen     根据启用状态获取所有史诗信息
     */
    int selectDemandNameByDId(String demandName);
    List<Map> selectDemandNameByDemandOpen();
    ResultDto updateOpenById(ProDemand proDemand);
    ResultDto updateStopById(ProDemand proDemand);
    List<Map> getAllDemandInfoByDemandOpen();


    /**
     * getDemandNameAndQuantity_Name        获取相同类型名
     * getDemandNameAndQuantity_Quantity    获取相同类型数量
     * getDemandNameAndQuantity             获取相同类型的史诗名称及数量
     */
    List<String> getDemandNameAndQuantity_Name();
    List<Integer> getDemandNameAndQuantity_Quantity();
    List<Map<String, Integer>> getDemandNameAndQuantity();
}
