package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null)
            return 0;
        dfs(root, false);
        return sum;
    }
    int dfs(TreeNode node, boolean isLeft) {
        if(node == null) return 0;
        // 왼쪽 노드의 리프노드일 경우 해당 노드의 값을 sum에 더한다.
        if(isLeft && node.left == null && node.right == null) {
            sum += node.val;
        }
        return dfs(node.left, true) + dfs(node.right, false);
    }
}
