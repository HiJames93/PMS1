package cn.james.pms_1.dao;

import cn.james.pms_1.entity.ProStory;
import cn.james.pms_1.entity.SysTab;

import java.util.List;
import java.util.Map;

public interface SysTabMenuDAO {

    List<SysTab> selectAll(SysTab sysTab);
    boolean insertById(SysTab sysTab);
    boolean updateById(SysTab sysTab);
    boolean deleteById(int id);


    /**
     * selectAllTabAvailable        获取所有已启用的菜单
     * selectTabTypeByTabId         根据选项卡ID获取选项卡类型
     * selectTabMenuTypeByTabId     根据选项卡ID获取菜单类型
     * updateOpenById               用于改变使能状态
     */
    List<Map> selectAllTabAvailable(String tabMenuType);
    List<Map> selectTabAllType();
    List<Map> selectTabAllMenuType();
    boolean updateOpenById(SysTab sysTab);
}
