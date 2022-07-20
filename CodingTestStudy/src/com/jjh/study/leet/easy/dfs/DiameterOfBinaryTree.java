package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class DiameterOfBinaryTree {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int x = dfs(node.left);
        int y = dfs(node.right);
        max = Math.max(max, x + y);

        return Math.max(x, y) + 1;
    }
}
