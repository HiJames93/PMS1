package cn.james.pms_1.dao;

import cn.james.pms_1.entity.ProStory;

import java.util.List;
import java.util.Map;

public interface ProStoryDAO {
    List<ProStory> selectAll(ProStory proStory);
    boolean insertById(ProStory proStory);
    boolean updateById(ProStory proStory);
    boolean deleteById(int id);

    /**
     * selectStoryNameByDType       根据灵感类型获取故事名称
     * updateOpenById               用于改变使能状态
     */
    List<Map> selectStoryNameByDType(String dType);
    boolean updateOpenById(ProStory proStory);
}
