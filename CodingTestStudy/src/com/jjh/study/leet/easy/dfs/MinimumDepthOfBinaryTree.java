package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
        return dfs(root, 1);
    }

	private int dfs(TreeNode root, int depth) {
		if(root.left == null && root.right == null) 
			return depth;
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		if(root.left != null)
			x = dfs(root.left, depth + 1);
		if(root.right != null)
			y = dfs(root.right, depth + 1);
		
		return Math.min(x, y);
	}
}
