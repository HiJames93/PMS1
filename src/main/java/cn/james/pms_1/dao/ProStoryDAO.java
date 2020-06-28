package cn.james.pms_1.dao;

import cn.james.pms_1.entity.ProStory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ProStoryDAO {
    List<ProStory> selectAll(ProStory proStory);

    /**
     * @Title: insertById
     * @Description: 根据ID插入
     * @param: [proStory]
     * @return: boolean
     * @date: 6/28/20 2:45 PM
     * @throws
     **/
    @Insert("insert into pro_story" +
            "(story_name, user_name, story_desc, story_info, story_ideasSource, story_type, story_open, createTime, lastTime)" +
            "value" +
            "(#{story.story_name}, #{story.user_name}, #{story.story_desc}, #{story.story_info}, #{story.story_ideasSource}, #{story.story_type}, #{story.story_open}, #{story.createTime}, #{story.lastTime})")
    boolean insertById(@Param("story")ProStory proStory);

    /**
     * @Title: updateById
     * @Description: 根据Id编辑
     * @param: [proStory]
     * @return: boolean
     * @date: 6/28/20 2:45 PM
     * @throws
     **/
    @Update("update pro_story " +
            "set " +
            "`story_name`=#{story_name}, `user_name`=#{user_name}, `story_desc`=#{story_desc},`story_info`=#{story_info}, `story_ideasSource`=#{story_ideasSource}, `story_type`=#{story_type}, `lastTime`=#{lastTime} " +
            "where `story_id`=#{story_id}")
    boolean updateById(ProStory proStory);

    /**
     * @Title: deleteById
     * @Description: 单删
     * @param: [story_id]
     * @return: boolean
     * @date: 6/28/20 2:44 PM
     * @throws
     **/
    @Delete("delete from pro_story where `story_id`=#{story_id}")
    boolean deleteById(@Param("story_id") int story_id);

    /**
     * @Title: updateOpenById
     * @Description: 用于改变使能状态
     * @param: [proStory]
     * @return: boolean
     * @date: 6/28/20 2:44 PM
     * @throws
     **/
    @Update("update pro_story " +
            "set " +
            "story_open = #{story_open} " +
            "where story_id = #{story_id}")
    boolean updateOpenById(ProStory proStory);

    /**
     * @Title: selectStoryNameByDType
     * @Description: 根据灵感类型获取故事名称
     * @param: [dType]
     * @return: java.util.List<java.util.Map>
     * @date: 6/28/20 2:44 PM
     * @throws
     **/
    List<Map> selectStoryNameByDType(String dType);
}
