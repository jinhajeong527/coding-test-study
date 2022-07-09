package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class BalancedBinaryTree {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        dfs(root);
        return result;
    }
    public int dfs(TreeNode node) {
        if(node == null) return 0;


        int x = dfs(node.left);
        int y = dfs(node.right);

        if(Math.abs(x-y) > 1) {
            result = false;
            return 0;
        }
        return Math.max(x, y) + 1;
    }

}
