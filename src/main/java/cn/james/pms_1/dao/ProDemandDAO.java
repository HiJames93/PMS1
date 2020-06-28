package cn.james.pms_1.dao;

import cn.james.pms_1.entity.ProDemand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ProDemandDAO {

    /**
     * @Title: selectAll
     * @Description: 全查询
     * @param: [proDemand]
     * @return: java.util.List<cn.james.pms_1.entity.ProDemand>
     * @date: 6/26/20 11:14 PM
     * @throws
     **/
    List<ProDemand> selectAll(@Param("proDemand") ProDemand proDemand);

    /**
     * @Title: insertOne
     * @Description: 新建表用
     * @param: [proDemand]
     * @return: boolean
     * @date: 6/26/20 11:12 PM
     * @throws
     **/
    @Insert("insert into pro_demand " +
            "(demand_name, user_name, demand_desc, demand_info, demand_ideasSource, demand_type, createTime, lastTime) " +
            "VALUES" +
            "(#{demand_name}, #{user_name}, #{demand_desc}, #{demand_info}, #{demand_ideasSource}, #{demand_type}, #{createTime}, #{lastTime})")
    boolean insertOne(ProDemand proDemand);

    /**
     * @Title: updateById
     * @Description: 编辑表用
     * @param: [proDemand]
     * @return: boolean
     * @date: 6/26/20 11:12 PM
     * @throws
     **/
    @Update("update pro_demand " +
            "set " +
            "demand_name=#{demand_name}, user_name=#{user_name}, demand_desc=#{demand_desc}, demand_info=#{demand_info}, demand_ideasSource=#{demand_ideasSource}, demand_type=#{demand_type}, lastTime=#{lastTime} " +
            "where demand_id=#{demand_id}")
    boolean updateById(ProDemand proDemand);

    /**
     * @Title: deleteById
     * @Description: 删除记录
     * @param: [id]
     * @return: boolean
     * @date: 6/26/20 11:13 PM
     * @throws
     **/
    @Delete("delete from pro_demand " +
            "where demand_id=#{demand_id}")
    boolean deleteById(int id);

    List<Map> selectDemandNameByDemandOpen();

    /**
     * @Title: selectDemandIdByDemandName
     * @Description: 根据名字获取id
     * @param: [demandName]
     * @return: int
     * @date: 6/26/20 11:14 PM
     * @throws
     **/
    int selectDemandIdByDemandName(String demandName);

    /**
     * @Title: updateOpenById
     * @Description: 用于改变使能状态
     * @param: [proDemand]
     * @return: boolean
     * @date: 6/26/20 11:12 PM
     * @throws
     **/
    @Update("update pro_demand " +
            "set " +
            "demand_open=#{demand_open} " +
            "where demand_id=#{demand_id}")
    boolean updateOpenById(ProDemand proDemand);

    int getDemandQuantityByType(String demandType);
    List<String> getDemandType();
}
