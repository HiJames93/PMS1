package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.SysTabMenuDAO;
import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProStory;
import cn.james.pms_1.entity.SysTab;
import cn.james.pms_1.server.SysTabMenuServer;
import cn.james.pms_1.vo.SysTabVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysTabMenuServerImpl implements SysTabMenuServer {

    @Autowired
    private SysTabMenuDAO sysTabMenuDAO;

    @Override
    public DataGridView getTabMenuListByPage(SysTabVo sysTabMenuVo) {
        Page<Object> page= PageHelper.startPage(sysTabMenuVo.getPage(),sysTabMenuVo.getLimit());
        List<SysTab> data=this.sysTabMenuDAO.selectAll(sysTabMenuVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public boolean insertById(SysTab sysTab) {
        try{
            if (sysTabMenuDAO.insertById(new SysTab(
                    sysTab.getTabId(),
                    sysTab.getTabName(),
                    sysTab.getTabMenuType(),
                    sysTab.getTabType(),
                    0))){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateById(SysTab sysTab) {
        try{
            if (sysTabMenuDAO.updateById(new SysTab(
                    sysTab.getTabId(),
                    sysTab.getTabName(),
                    sysTab.getTabMenuType(),
                    sysTab.getTabType()))){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        return sysTabMenuDAO.deleteById(id);
    }

    @Override
    public List<Map> selectAllTabAvailable(String tabMenuType) {
        return sysTabMenuDAO.selectAllTabAvailable(tabMenuType);
    }

    @Override
    public boolean startTab(SysTab sysTab) {
        try{
            if (sysTabMenuDAO.updateOpenById(new SysTab(sysTab.getTabId(), true))){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean stopTab(SysTab sysTab) {
        try{
            if (sysTabMenuDAO.updateOpenById(new SysTab(sysTab.getTabId(), false))){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Map> getAllTabType() {
        return sysTabMenuDAO.selectTabAllType();
    }

    @Override
    public List<Map> getAllTabMenuType() {
        return sysTabMenuDAO.selectTabAllMenuType();
    }
}
