package com.jjh.study.leet.easy.dfs;

import java.util.ArrayList;
import java.util.List;

import com.jjh.study.ds.TreeNode;

public class BinaryTreeInorderTraversal2 {
	public List<Integer> inorderTraversal(TreeNode root) {//left-root-right
		
		List<Integer> answer = new ArrayList<Integer>();
        if(root == null) return answer;
        answer.addAll(inorderTraversal(root.left));
        answer.add(root.val);
        answer.addAll(inorderTraversal(root.right));
        
        return answer;
    }

}
