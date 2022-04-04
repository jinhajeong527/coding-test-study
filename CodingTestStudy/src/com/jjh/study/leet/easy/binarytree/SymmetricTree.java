package com.jjh.study.leet.easy.binarytree;

import com.jjh.study.ds.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        return  checkIfSymmentric(root.left, root.right);
    }

    private boolean checkIfSymmentric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true; //둘다  null이면 true이다.
        if(left == null || right == null) return false;//하나만 null이면 false이다.

        return (left.val == right.val) && checkIfSymmentric(left.left, right.right) && checkIfSymmentric(left.right, right.left);

    }
}
