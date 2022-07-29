package com.jjh.study.leet.easy.dfs;

import java.util.ArrayList;
import java.util.List;

import com.jjh.study.ds.TreeNode;

public class LeafSimilarTrees {
	// 노드의 leaf값 순서대로 담아줄 리스트
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	// 어떤 리스트에 담을 건지 구분하기 위한 flag
	String flag1 = "first";
	String flag2 = "second";
	
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		
		dfs(root1, flag1);
		dfs(root2, flag2);
		// 리스트의 사이즈가 다르면 같은게 아니므로 false 리턴한다.
		if(list1.size() != list2.size()) return false;
		for(int i = 0; i < list1.size(); i++) {
			// 비교 도중에 다른 것 발견하면 false 리턴한다.
			if(list1.get(i) != list2.get(i)) 
				return false;
		}
		return true;
    }

	private void dfs(TreeNode node, String flag) {
		if(node == null) return;
		if(node.left == null && node.right == null) {
			if(flag.equals(flag1)) list1.add(node.val);
			else list2.add(node.val);
		}
		dfs(node.left, flag);
		dfs(node.right, flag);
	}
}
