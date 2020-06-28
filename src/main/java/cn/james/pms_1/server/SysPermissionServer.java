package cn.james.pms_1.server;



import cn.james.pms_1.domain.TreeNode;

import java.util.List;

public interface SysPermissionServer {
    List<TreeNode> selectAll();
}
