package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
    	if(root.left == null && root.right == null) return -1;
    	int left = root.left.val;
    	int right = root.right.val;
    	if(left == root.val) {
    		left = findSecondMinimumValue(root.left);
    	}
    	if(right == root.val) {
    		right = findSecondMinimumValue(root.right);
    	}
    	if(left != -1 && right != -1) {
    		return Math.min(left, right);
    	}
    	if(left != -1) return left;
    	else return right;
    }

}
