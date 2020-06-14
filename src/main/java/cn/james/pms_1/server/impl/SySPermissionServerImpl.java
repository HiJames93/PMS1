package cn.james.pms_1.server.impl;

import cn.james.pms_1.dao.SySPermissionDAO;
import cn.james.pms_1.domain.TreeNode;
import cn.james.pms_1.entity.SysPermission;
import cn.james.pms_1.server.SySPermissionServer;
import cn.james.pms_1.util.TreeNodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SySPermissionServerImpl implements SySPermissionServer {

    @Autowired
    private SySPermissionDAO sySPermissionDAO;

    @Override
    public List<TreeNode> selectAll() {
        List<TreeNode> treeNodes=new ArrayList<>();
        List<SysPermission> permissionList=this.sySPermissionDAO.selectAll();
        for(SysPermission permission:permissionList){
            TreeNode treeNode=new TreeNode();
            treeNode.setId(permission.getId());
            treeNode.setPid(permission.getPid());
            treeNode.setTitle(permission.getPName());
            treeNode.setIcon(permission.getIcon());
            treeNode.setHref(permission.getHref());
            treeNode.setSpread(permission.getPOpen()==1?true:false);
            treeNodes.add(treeNode);
        }
        return TreeNodeBuilder.build(treeNodes,1);
    }
}
