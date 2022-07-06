package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        SubtreeOfAnotherTree soat = new SubtreeOfAnotherTree();
        TreeNode root = new TreeNode(1, null, null);
        TreeNode subRoot = new TreeNode(0, null, null);
        System.out.println(soat.isSubtree(root, subRoot));

    }
    boolean isOnlyOne = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot.left == null && subRoot.right == null) {
            isOnlyOne = true;
            if(root.left == null && root.right == null && root.val != subRoot.val) return false;
        }

        return dfs(root, subRoot);
    }
    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if((root != null && subRoot == null) || (root == null && subRoot != null) && !isOnlyOne) return false;
        if(root.val == subRoot.val) {
            System.out.println(root.val);
            System.out.println(subRoot.val);
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        } else { // 같지 않으니까 subRoot의 루트 값과 같은 노드 발견할 때 까지 깊이 우선 탐색을 한다.
            return dfs(root.left, subRoot) || dfs(root.right, subRoot);
        }
    }

}
