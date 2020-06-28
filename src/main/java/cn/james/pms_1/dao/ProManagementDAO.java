package cn.james.pms_1.dao;

import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.entity.ProManagement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProManagementDAO
 * @Desciption: 项目管理方法
 * @author: James
 * @date: 2020-06-24 1:14 PM
 * @version: 1.0
 */
public interface ProManagementDAO {
    /**
     * @Title: insertById
     * @Description: 根据ID添加
     * @param: [proManagement]
     * @return: boolean
     * @date: 6/24/20 2:43 PM
     * @throws
     **/
    @Insert("insert into pro_management" +
            "(pro_name, pro_organizerName, pro_desc, pro_info, pro_type, demand_type, story_type, pro_createTime, pro_lastTime)" +
            "value" +
            "(#{pro_name}, #{pro_organizerName}, #{pro_desc}, #{pro_info}, #{pro_type}, #{demand_type}, #{story_type}, #{pro_createTime}, #{pro_lastTime})")
    boolean insertById(ProManagement proManagement);
    /**
     * @Title: updateById
     * @Description: 根据ID更新
     * @param: [proManagement]
     * @return: boolean
     * @date: 6/24/20 2:43 PM
     * @throws
     **/
    @Update("update pro_management set\n" +
            "`pro_name`=#{pro_name}\n" +
            "`pro_organizerName`=#{pro_organizerName}\n" +
            "`pro_desc`=#{pro_desc}\n" +
            "`pro_info`=#{pro_info}\n" +
            "`pro_type`=#{pro_type}\n" +
            "`demand_type`=#{demand_type}\n" +
            "`story_type`=#{story_type} " +
            "where `pro_id`=#{pro_id}")
    boolean updateById(ProManagement proManagement);
    /**
     * @Title: deleteById
     * @Description: 根据ID删除
     * @param: [pro_id]
     * @return: boolean
     * @date: 6/24/20 2:44 PM
     * @throws
     **/
    @Delete("delete from pro_management where pro_id=#{pro_id}")
    boolean deleteById(int pro_id);

    /**
     * @Title: getAllDesc
     * @Description: 获取所有项目的简报
     * @param: []
     * @return: java.util.List<java.util.Map>
     * @date: 6/24/20 2:28 PM
     * @throws
     **/
    List<Map<String,Object>> getAllDesc();
    /**
     * @Title: updatePro_openById
     * @Description: 更新启用状态
     * @param: [pro_id]
     * @return: boolean
     * @date: 6/24/20 2:43 PM
     * @throws
     **/
    boolean updatePro_openById(int pro_id);
    /**
     * @Title: selectAll
     * @Description: 全查询 名称，发起人，各种类型都能查
     * @param: [proManagement]
     * @return: java.util.List<cn.james.pms_1.entity.ProManagement>
     * @date: 6/24/20 2:44 PM
     * @throws
     **/
    List<ProManagement> getAllProBy(@Param("pro") ProManagement proManagement);
}
