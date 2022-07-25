package com.jjh.study.leet.easy.dfs;

import java.util.ArrayList;
import java.util.List;

import com.jjh.study.ds.TreeNode;

public class BinaryTreePreorderTraversal {
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) return list;
		list.add(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
        return list;
    }
}
