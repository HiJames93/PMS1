package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.ProManagementDAO;
import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.entity.ProManagement;
import cn.james.pms_1.server.ProManagementService;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.ProManagementVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProManagementServiceImpl
 * @Desciption:
 * @author: James
 * @date: 2020-06-24 2:28 PM
 * @version: 1.0
 */
@Service
public class ProManagementServiceImpl implements ProManagementService {

    @Autowired
    private ProManagementDAO proManagementDAO;

    @Override
    public DataGridView getProListByPage(ProManagementVo proManagementVo) {
        Page<Object> page= PageHelper.startPage(proManagementVo.getPage(),proManagementVo.getLimit());
        List<ProManagement> data=this.proManagementDAO.getAllProBy(proManagementVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public ResultDto addPro(ProManagement proManagement) {
        return null;
    }

    @Override
    public ResultDto editPro(ProManagement proManagement) {
        return null;
    }

    @Override
    public ResultDto deletePro(ProManagement proManagement) {
        return null;
    }

    @Override
    public ResultDto startPro(int pro_id) {
        return null;
    }

    @Override
    public ResultDto stopPro(int pro_id) {
        return null;
    }

    @Override
    public List<Map<String,Object>> getAllDesc() {
        return proManagementDAO.getAllDesc();
    }
}
