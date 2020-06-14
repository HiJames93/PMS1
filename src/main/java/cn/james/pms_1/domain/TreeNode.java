package cn.james.pms_1.domain;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode {
    private String title;
    private String icon;
    private String href;
    private int id;
    private int pid;
    private boolean Spread;
    private List<TreeNode> children = new ArrayList<>();
}
