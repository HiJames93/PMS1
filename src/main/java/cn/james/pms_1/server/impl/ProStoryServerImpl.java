package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.ProDemandDAO;
import cn.james.pms_1.dao.ProStoryDAO;
import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProStory;
import cn.james.pms_1.server.ProStoryServer;
import cn.james.pms_1.vo.ProStoryVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProStoryServerImpl implements ProStoryServer {

    @Autowired
    private ProStoryDAO proStoryDAO;
    @Autowired
    private ProDemandDAO proDemandDAO;

    @Override
    public DataGridView getStoryListByPage(ProStoryVo proStoryVo) {
        Page<Object> page= PageHelper.startPage(proStoryVo.getPage(),proStoryVo.getLimit());
        List<ProStory> data=this.proStoryDAO.selectAll(proStoryVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public boolean insertById(ProStory proStory) {
        try{
            // 新建故事
            if (proStoryDAO.insertById(
                    new ProStory(
                            proStory.getStory_name(),
                            proStory.getUser_name(),
                            proStory.getStory_desc(),
                            proStory.getStory_info(),
                            proStory.getStory_ideasSource()))){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateById(ProStory proStory) {
        try{
            if (proStoryDAO.updateById(new ProStory(
                    proStory.getStory_id(),
                    proStory.getStory_name(),
                    proStory.getUser_name(),
                    proStory.getStory_desc(),
                    proStory.getStory_info(),
                    proStory.getStory_ideasSource(),
                    proStory.getStory_type()))){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(int story_id) {
        try{
            if (proStoryDAO.deleteById(story_id)){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Map> selectStoryNameByDType(String dType) {
        return proStoryDAO.selectStoryNameByDType(dType);
    }


    @Override
    public boolean startStory(ProStory proStory) {
        try{
            if (proStoryDAO.updateOpenById(new ProStory(proStory.getStory_id(),true))){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean stopStory(ProStory proStory) {
        try{
            if (proStoryDAO.updateOpenById(new ProStory(proStory.getStory_id(), false))){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
