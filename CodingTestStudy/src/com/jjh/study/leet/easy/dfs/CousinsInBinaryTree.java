package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode node =
                new TreeNode(1,new TreeNode(2,new TreeNode(4, null, null), null), new TreeNode(3, null, null));
        CousinsInBinaryTree ct = new CousinsInBinaryTree();
        System.out.println( ct.isCousins(node, 4, 3));
    }
    int xParentValue;
    int yParentValue;
    int xDepth = 0;
    int yDepth = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(x == root.val || y == root.val) return false;
        dfs(root, root.left, x, y, 0);
        dfs(root, root.right, x, y, 0);
        if(xDepth == yDepth && xParentValue != yParentValue) return true;
        return false;
    }

    private void dfs(TreeNode root, TreeNode node, int x, int y, int depth) {
        if(node == null) return;
        if(node.val == x) {
            xParentValue = root.val;
            xDepth = depth;
            return;
        }
        if(node.val == y) {
            System.out.println(node.val);
            yParentValue = root.val;
            yDepth = depth;
            return;
        }
        dfs(node, node.left, x, y, depth + 1);
        dfs(node, node.right, x, y, depth + 1);
    }
}
