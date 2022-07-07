package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        SubtreeOfAnotherTree soat = new SubtreeOfAnotherTree();
        TreeNode root = new TreeNode(3, null, null);
        root.left = new TreeNode(4, new TreeNode(1, null, null), null);
        root.right = new TreeNode(5, new TreeNode(2, null, null), null);
        TreeNode subRoot = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(2, null, null));
        System.out.println(soat.isSubtree(root, subRoot));

    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(dfs(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); 
    }
    private boolean dfs(TreeNode root, TreeNode subRoot) {
    	if(root == null && subRoot == null) return true;
    	if(root == null || subRoot == null) return false;
    	if(root.val != subRoot.val) return false;
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }

}
