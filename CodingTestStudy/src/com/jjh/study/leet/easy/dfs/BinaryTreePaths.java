package com.jjh.study.leet.easy.dfs;

import com.jjh.study.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> answer = new ArrayList<>();
        if(root==null) return answer;
        //null이 아니라면
        String pathStr = "";
        getBinaryTreePaths(root, pathStr, answer);

        return answer;
    }
    public void getBinaryTreePaths(TreeNode root, String path, ArrayList<String> list) {
            if(root.left == null && root.right==null) list.add(path +Integer.toString(root.val));
            if(root.left != null) getBinaryTreePaths(root.left, path+Integer.toString(root.val)+"->", list);
            if(root.right != null) getBinaryTreePaths(root.right, path+Integer.toString(root.val)+"->", list);
    }
}
