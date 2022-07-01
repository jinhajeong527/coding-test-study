package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = dfs(p, q);
        return result;
    }
    public boolean dfs(TreeNode pNode, TreeNode qNode) {
        // 마지막 리프 노드인지 체크한다. 자식이 없을 것이기 때문에 여기까지 왔을 때는 전부 일치했다는 뜻이된다.
        if(pNode == null && qNode == null) return true;
        if(pNode != null && qNode != null) {
            if(pNode.val != qNode.val) return false;
            return dfs(pNode.left, qNode.left) && dfs(pNode.right, qNode.right);
        }
        return false;
    }
}
