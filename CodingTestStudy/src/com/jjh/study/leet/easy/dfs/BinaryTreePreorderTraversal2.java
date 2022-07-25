package com.jjh.study.leet.easy.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.jjh.study.ds.TreeNode;

public class BinaryTreePreorderTraversal2 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()) {
			if(root != null) { // 루트 - 왼쪽자식노드 - 오른쪽자식노드
				list.add(root.val);
				stack.push(root.right);
				root = root.left;
			} else { // 더 이상 왼쪽 노드가 없으면 오른쪽 노드 탐색한다.
				root = stack.pop();
			}
		}
		return list;
    }
}
