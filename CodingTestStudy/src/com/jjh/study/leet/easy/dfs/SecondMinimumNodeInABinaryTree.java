package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class SecondMinimumNodeInABinaryTree {
    int secondMinValue = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left != null) {

            if(root.left.val == root.right.val) {
                dfs(root.left, root.right);
            }

            if(root.left.val > root.right.val) {
                secondMinValue = root.left.val;

            } else if(root.left.val < root.right.val) {
                secondMinValue = root.right.val;
            }
        }
        return secondMinValue;
    }

    private void dfs(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode.left == null && rightNode.left == null) {
            System.out.println("여기?");
            return;
        }
        else if(leftNode.left == null) findSecondMinimumValue(rightNode);
        else if(rightNode.left == null) findSecondMinimumValue(leftNode);
        else if(leftNode.left != null && rightNode.left != null) {
            if(leftNode.left.val == rightNode.left.val) {
                // 여기 생각해보기
            }
            int max1 = Math.max(leftNode.left.val, leftNode.right.val);
            int max2 = Math.max(rightNode.left.val, rightNode.right.val);
            secondMinValue = max1 > max2 ? max2 : max1;
        }
    }


}
