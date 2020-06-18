package cn.james.pms_1.server;

import cn.james.pms_1.domain.DataGridView;
import cn.james.pms_1.entity.ProStory;
import cn.james.pms_1.entity.SysTab;
import cn.james.pms_1.vo.SysTabVo;

import java.util.List;
import java.util.Map;

public interface SysTabMenuServer {

    /**
     * getFeaturesListByPage        显示所有故事
     * insertById                   新建故事
     * updateById                   更新故事
     * deleteById                   删除故事
     */
    DataGridView getTabMenuListByPage(SysTabVo sysTabMenuVo);
    boolean insertById(SysTab sysTab);
    boolean updateById(SysTab sysTab);
    boolean deleteById(int id);

    /**
     * selectAllTabAvailable        获取所有已启用的菜单
     */
    List<Map> selectAllTabAvailable(String tabMenuType);
    /**
     * stopStory                    停用故事
     * startStory                   启用故事
     * selectTabTypeByTabId         根据选项卡ID获取选项卡类型
     * selectTabMenuTypeByTabId     根据选项卡ID获取菜单类型
     */
    boolean startTab(SysTab sysTab);
    boolean stopTab(SysTab sysTab);
    List<Map> getAllTabType();
    List<Map> getAllTabMenuType();
}
