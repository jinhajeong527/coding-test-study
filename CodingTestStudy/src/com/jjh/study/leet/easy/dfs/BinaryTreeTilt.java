package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class BinaryTreeTilt {
	int sum = 0;
	public int findTilt(TreeNode root) {
		postorder(root);
		return sum;
    }
	public int postorder(TreeNode root) { // 왼쪽 자식 노드-오른쪽 자식 노드-루트노드 순서
		if(root == null) {
			// 자식 노드 없으면 0 리턴한다.
			return 0;
		}
		int leftVal = postorder(root.left);
		int rightVal = postorder(root.right);
		// 섭트리의 부모의 tilt 값을 구한다.
		sum += Math.abs(leftVal - rightVal);
		// 구하고 난 다음에는 자식 노트들의 값과 루트 값 리턴해서 해당 섭트리의 부모의 tilt 값 구하는데 사용할 수 있도록 한다.
		return leftVal + rightVal + root.val;
		
	}

}
