package com.jjh.study.leet.easy.dfs;

import apple.laf.JRSUIUtils;
import com.jjh.study.ds.TreeNode;

import java.util.*;

public class FindingModeInBST {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        // 맵을 값을 기준으로 내림차순 정렬
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : entryList) {
            if(entry.getValue() >= max) {
                max = entry.getValue();
                list.add(entry.getKey());
            } else break;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    private void dfs(TreeNode node) {
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        if(node.left == null && node.right == null) return;
        if(node.left != null) dfs(node.left);
        if(node.right != null) dfs(node.right);
    }
}
