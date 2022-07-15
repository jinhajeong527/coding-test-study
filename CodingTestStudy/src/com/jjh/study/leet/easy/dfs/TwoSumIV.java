package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

import java.util.HashSet;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    public boolean dfs(TreeNode node, int k, HashSet<Integer> set) {
        if(node == null) return false;
        if(set.contains(k-node.val)) return true;
        set.add(node.val);
        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}
