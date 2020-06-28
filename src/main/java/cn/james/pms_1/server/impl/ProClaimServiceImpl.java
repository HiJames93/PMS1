package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.ProClaimDAO;
import cn.james.pms_1.entity.ProClaim;
import cn.james.pms_1.server.ProClaimService;
import cn.james.pms_1.util.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProClaimServiceImpl
 * @Desciption:
 * @author: James
 * @date: 2020-06-28 5:55 PM
 * @version: 1.0
 */

@Service
public class ProClaimServiceImpl implements ProClaimService {

    @Autowired
    private ProClaimDAO proClaimDAO;

    @Override
    public List<ProClaim> findAllClaimed() {
        return proClaimDAO.findAllClaimed();
    }

    @Override
    public List<ProClaim> findAllUnclaimed() {
        return proClaimDAO.findAllUnclaimed();
    }

    @Override
    public ResultDto addOne(ProClaim proClaim) {
        return ResultDto.ADD_CLAIM_FAILURE;
    }

    @Override
    public ResultDto updatePrincipal(ProClaim proClaim) {
        return ResultDto.UPDATE_CLAIM_FAILURE;
    }

    @Override
    public ResultDto deleteOne(ProClaim proClaim) {
        return ResultDto.DELETE_CLAIM_FAILURE;
    }
}
