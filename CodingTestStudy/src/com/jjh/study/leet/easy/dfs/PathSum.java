package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class PathSum {
    public static void main(String[] args) {

        TreeNode tnLeft = new TreeNode(2, null,null);
        TreeNode tnRight = new TreeNode(3, null,null);
        TreeNode tnParent = new TreeNode(1, tnLeft, tnRight);
        PathSum ps = new PathSum();

        System.out.println(ps.hasPathSum(tnParent, 5));
    }
    int targetNumber;
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        targetNumber = targetSum;
        int currentValue = 0;
        dfs(root, currentValue);
        return result;
    }
    public void dfs(TreeNode node, int currentValue) {
        if(node == null) return;
        currentValue += node.val;
        if(node.left == null && node.right == null) {
            if(currentValue == targetNumber) {
                result = true;
            }
            return;
        }
        dfs(node.left, currentValue);
        dfs(node.right, currentValue);
    }
}
