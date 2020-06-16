package cn.james.pms_1.server;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProStory;
import cn.james.pms_1.vo.ProStoryVo;

import java.util.List;
import java.util.Map;

public interface ProStoryServer {

    /**
     * getFeaturesListByPage        显示所有故事
     * insertById                   新建故事
     * updateById                   更新故事
     * deleteById                   删除故事
     */
    DataGridView getStoryListByPage(ProStoryVo proStoryVo);
    boolean insertById(ProStory proStory);
    boolean updateById(ProStory proStory);
    boolean deleteById(int id);

    /**
     * selectStoryNameByDType   根据灵感类型获取故事名称
     * stopStory                停用故事
     * startStory               启用故事
     */
    List<Map> selectStoryNameByDType(String dType);
    boolean startStory(ProStory proStory);
    boolean stopStory(ProStory proStory);
}
