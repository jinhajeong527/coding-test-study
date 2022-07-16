package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class TwoSumInOrder {
    List<Integer> nums = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        for(int i = 0, j = nums.size() - 1; i < j;) {
            int twoSum = nums.get(i) + nums.get(j);
            if(twoSum == k) return true;
            //두 개를 합친 값이 k 보다 작으면 i를 +1 해주어 더 큰 값과 더해본다.
            else if(twoSum < k) i++;
            //두 개를 합친 값이 k 보다 크다면 j--를 통해 더 작은 값과 더해본다.
            else j--;
        }
        return false;
    }
    //InOrder 방식으로 순회할시에 이진탐색트리는 오름차순으로 값을 리스트에 담을 수 있다.
    public void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        nums.add(node.val);
        inorder(node.right);
    }

}
