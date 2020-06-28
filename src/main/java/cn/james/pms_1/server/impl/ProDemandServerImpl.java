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
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
            if (proDemandDAO.insertOne(new ProDemand(
                    proDemand.getDemand_name(),
                    proDemand.getUser_name(),
                    proDemand.getDemand_desc(),
                    proDemand.getDemand_info(),
                    proDemand.getDemand_ideasSource(),
                    proDemand.getDemand_type()))){
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
            if (proDemandDAO.updateById(new ProDemand(
                    proDemand.getDemand_id(),
                    proDemand.getDemand_name(),
                    proDemand.getUser_name(),
                    proDemand.getDemand_desc(),
                    proDemand.getDemand_info(),
                    proDemand.getDemand_ideasSource(),
                    proDemand.getDemand_type()
            ))){
                return ResultDto.UPDATE_DEMAND_SUCCESS;
            }
            return ResultDto.UPDATE_DEMAND_FAILURE;
        }catch (Exception e){
            e.printStackTrace();
            return ResultDto.UPDATE_DEMAND_FAILURE;
        }
    }

    @Override
    public ResultDto deleteById(int demandId) {
        try {
            if (proDemandDAO.deleteById(demandId)){
                return ResultDto.DELETE_DEMAND_SUCCESS;
            }
            return ResultDto.DELETE_DEMAND_FAILURE;
        }catch (Exception e){
            return ResultDto.DELETE_DEMAND_FAILURE;
        }
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
    public ResultDto updateOpenById(ProDemand proDemand) {
        try {
            if (proDemandDAO.updateOpenById(new ProDemand(proDemand.getDemand_id(),true))){
                return ResultDto.UPDATE_DEMAND_SUCCESS;
            }
            return ResultDto.UPDATE_DEMAND_FAILURE;
        }catch (Exception e){
            return ResultDto.UPDATE_DEMAND_FAILURE;
        }
    }

    @Override
    public ResultDto updateStopById(ProDemand proDemand) {
        try {
            if (proDemandDAO.updateOpenById(new ProDemand(proDemand.getDemand_id(),false))){
                return ResultDto.STOP_DEMAND_SUCCESS;
            }
            return ResultDto.STOP_DEMAND_FAILURE;
        }catch (Exception e){
            return ResultDto.STOP_DEMAND_FAILURE;
        }
    }

    @Override
    public List<Map> getAllDemandInfoByDemandOpen() {
        return proDemandDAO.selectAllDemandDescByDemandOpen();
    }

    @Override
    public List<String> getDemandNameAndQuantity_Name() {
        return proDemandDAO.getDemandType();
    }

    @Override
    public List<Integer> getDemandNameAndQuantity_Quantity() {
        List<Integer> quantityInfos = new ArrayList<>();
        for (String s : getDemandNameAndQuantity_Name()) {
            quantityInfos.add(proDemandDAO.getDemandQuantityByType(s));
        }
        return quantityInfos;
    }

    @Override
    public List<Map<String, Integer>> getDemandNameAndQuantity() {
        Map<String, Integer> demandInfos = new HashMap<>();
        List<Map<String, Integer>> demandInfosList = new ArrayList<>();
        for (int i = 0; i < getDemandNameAndQuantity_Name().size(); i++) {
            demandInfos.put(getDemandNameAndQuantity_Name().get(i),getDemandNameAndQuantity_Quantity().get(i));
        }

        demandInfosList.add(demandInfos);
        return demandInfosList;
    }
}
