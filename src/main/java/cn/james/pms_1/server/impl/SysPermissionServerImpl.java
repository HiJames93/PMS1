package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.SysPermissionDAO;
import cn.james.pms_1.domain.TreeNode;
import cn.james.pms_1.entity.SysPermission;
import cn.james.pms_1.server.SysPermissionServer;
import cn.james.pms_1.util.TreeNodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysPermissionServerImpl implements SysPermissionServer {

    @Autowired
    private SysPermissionDAO sysPermissionDAO;

    @Override
    public List<TreeNode> selectAll() {
        List<TreeNode> treeNodes=new ArrayList<>();
        List<SysPermission> permissionList=this.sysPermissionDAO.selectAll();
        for(SysPermission permission:permissionList){
            TreeNode treeNode=new TreeNode();
            treeNode.setId(permission.getId());
            treeNode.setPid(permission.getPermissionId());
            treeNode.setTitle(permission.getPermissionName());
            treeNode.setIcon(permission.getIcon());
            treeNode.setHref(permission.getHref());
            treeNode.setSpread(permission.getPermissionOpen()==1?true:false);
            treeNodes.add(treeNode);
        }
        return TreeNodeBuilder.build(treeNodes,1);
    }
}
