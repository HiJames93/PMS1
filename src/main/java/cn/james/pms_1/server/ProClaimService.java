package cn.james.pms_1.server;

import cn.james.pms_1.entity.ProClaim;
import cn.james.pms_1.util.ResultDto;

import java.util.List;

/**
 * @ClassName: ProClaimService
 * @Desciption:
 * @author: James
 * @date: 2020-06-28 5:53 PM
 * @version: 1.0
 */
public interface ProClaimService {
    /**
     * @Title: findAllClaimed
     * @Description: 获取全部已认领任务
     * @param: []
     * @return: java.util.List<cn.james.pms_1.entity.ProClaim>
     * @date: 6/28/20 5:47 PM
     * @throws
     **/
    List<ProClaim> findAllClaimed();

    /**
     * @Title: findAllUnclaimed
     * @Description: 获取全部未认领任务
     * @param: []
     * @return: java.util.List<cn.james.pms_1.entity.ProClaim>
     * @date: 6/28/20 5:48 PM
     * @throws
     **/
    List<ProClaim> findAllUnclaimed();

    /**
     * @Title: insertOne
     * @Description: 新建一条认领信息
     * @param: [proClaim]
     * @return: ResultDto
     * @date: 6/28/20 5:49 PM
     * @throws
     **/
    ResultDto addOne(ProClaim proClaim);

    /**
     * @Title: updateOne
     * @Description: 更新认领人  针对手抖选错的情况
     * @param: [proClaim]
     * @return: ResultDto
     * @date: 6/28/20 5:51 PM
     * @throws
     **/
    ResultDto updatePrincipal(ProClaim proClaim);

    /**
     * @Title: deleteOne
     * @Description: 解除认领关系
     * @param: [proClaim]
     * @return: ResultDto
     * @date: 6/28/20 5:52 PM
     * @throws
     **/
    ResultDto deleteOne(ProClaim proClaim);
}
