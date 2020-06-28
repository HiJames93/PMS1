package cn.james.pms_1.server;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProManagement;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.ProDemandVo;
import cn.james.pms_1.vo.ProManagementVo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProManagementService
 * @Desciption:
 * @author: James
 * @date: 2020-06-24 2:27 PM
 * @version: 1.0
 */
public interface ProManagementService {
    /**
     * @Title: selectAll
     * @Description: 全查询 名称，发起人，各种类型都能查
     * @param: [proManagement]
     * @return: java.util.List<cn.james.pms_1.entity.ProManagement> 史诗列表【ID，名称】，故事列表【ID，名称】
     * @date: 6/24/20 2:44 PM
     * @throws
     **/
    DataGridView getProListByPage(ProManagementVo proManagementVo);
    /**
     * @Title: addPro
     * @Description: 添加项目
     * @param: [proManagement]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/24/20 2:39 PM
     * @throws
     **/
    ResultDto addPro(ProManagement proManagement);
    /**
     * @Title: editPro
     * @Description: 修改项目
     * @param: [proManagement]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/24/20 2:39 PM
     * @throws
     **/
    ResultDto editPro(ProManagement proManagement);
    /**
     * @Title: deletePro
     * @Description: 删除项目
     * @param: [proManagement]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/24/20 2:40 PM
     * @throws
     **/
    ResultDto deletePro(ProManagement proManagement);
    /**
     * @Title: startPro
     * @Description: 启用项目
     * @param: [pro_id]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/24/20 2:40 PM
     * @throws
     **/
    ResultDto startPro(int pro_id);
    /**
     * @Title: stopPro
     * @Description: 停用项目
     * @param: [pro_id]
     * @return: cn.james.pms_1.util.ResultDto
     * @date: 6/24/20 2:41 PM
     * @throws
     **/
    ResultDto stopPro(int pro_id);



    /**
     * @Title: getAllDesc
     * @Description: 用于 项目展示页列表
     * @param: []
     * @return: java.util.List<java.util.Map>
     * @date: 6/24/20 2:27 PM
     * @throws
     **/
    List<Map<String,Object>> getAllDesc();
}
