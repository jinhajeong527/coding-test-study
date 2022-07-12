package com.jjh.study.leet.easy.dfs;

import apple.laf.JRSUIUtils;
import com.jjh.study.ds.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumAbsoluteDifferenceInBST {
    // dfs 탐색을 통해 발견한 모든 노드 값 담을 리스트
    ArrayList<Integer> list;
    public int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();
        list.add(root.val);
        dfs(root);

        Integer[] arr = list.toArray(new Integer[list.size()]);
        Arrays.sort(arr);

        int min = arr[1] - arr[0];
        if(list.size() > 2)
            for(int i = 2; i < arr.length; i++)
                min = Math.abs(arr[i]- arr[i-1]) > min ? min : Math.abs(arr[i]- arr[i-1]);

        return min;
    }
    public void dfs(TreeNode node) {
        if(node == null) return;

        if(node.left != null) list.add(node.left.val);
        if(node.right != null) list.add(node.right.val);

        dfs(node.left);
        dfs(node.right);
    }
}
