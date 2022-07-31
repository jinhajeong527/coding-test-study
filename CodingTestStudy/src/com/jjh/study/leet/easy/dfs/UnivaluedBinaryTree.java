package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

public class UnivaluedBinaryTree {
    boolean result = true;
    public boolean isUnivalTree(TreeNode root) {
        int rootValue = root.val;
        dfs(root, rootValue);
        return result;
    }

    private void dfs(TreeNode root, int rootValue) {
        //하나라도 다르면 정답은 false이므로 이미 result가 false라면 다 리턴한다.
        if(result == false) return;
        if(root == null) return;
        if(rootValue != root.val) {
            //값이 다르면 result false로 바꿔주고 리턴한다.
            result = false;
            return;
        }
        dfs(root.left, rootValue);
        dfs(root.right, rootValue);
    }
}
