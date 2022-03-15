package com.jjh.study.leet.easy.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.jjh.study.ds.TreeNode;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {//left-root-right
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> answer = new ArrayList<Integer>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()) {
        	while(current != null) { //가장 왼쪽의 leaf로 갈 때까지 스택에 계속 추가해준다.
        		stack.push(current);
        		current = current.left;
        	}
        	//left가 null이면 while문 탈출할 것. 
        	
        	current = stack.pop();
        	answer.add(current.val);
        	current = current.right; //null이면 아직 스택은 비어있지 않으므로, 또 스택에서 뽑아낸다. 
        	
        }
        return answer;
    }

}
