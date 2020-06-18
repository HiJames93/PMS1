package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.ProDemandDAO;
import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProDemand;
import cn.james.pms_1.entity.ProStory;
import cn.james.pms_1.server.ProDemandServer;
import cn.james.pms_1.util.ResultDto;
import cn.james.pms_1.vo.ProDemandVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProDemandServerImpl implements ProDemandServer {

    @Autowired
    private ProDemandDAO proDemandDAO;


    @Override
    public DataGridView getDemandListByPage(ProDemandVo proDemandVo) {
        Page<Object> page= PageHelper.startPage(proDemandVo.getPage(),proDemandVo.getLimit());
        List<ProDemand> data=this.proDemandDAO.selectAll(proDemandVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public ResultDto insertById(ProDemand proDemand) {
        try {
            if (proDemandDAO.insertById(proDemand)){
                return ResultDto.ADD_DEMAND_SUCCESS;
            }
            return ResultDto.ADD_DEMAND_FAILURE;
        }catch (Exception e){
            return ResultDto.ADD_DEMAND_FAILURE;
        }
    }

    @Override
    public ResultDto updateById(ProDemand proDemand) {
        try {
            if (proDemandDAO.updateById(proDemand)){
                return ResultDto.UPDATE_DEMAND_SUCCESS;
            }
            return ResultDto.UPDATE_DEMAND_FAILURE;
        }catch (Exception e){
            return ResultDto.UPDATE_DEMAND_FAILURE;
        }
    }

    @Override
    public ResultDto deleteById(int id) {
        try {
            if (proDemandDAO.deleteById(id)){
                return ResultDto.DELETE_DEMAND_SUCCESS;
            }
            return ResultDto.DELETE_DEMAND_FAILURE;
        }catch (Exception e){
            return ResultDto.DELETE_DEMAND_FAILURE;
        }
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

    @Override
    public List<Map> getAllDemandInfoByDemandOpen() {
        return proDemandDAO.selectAllDemandDescByDemandOpen();
    }
}
