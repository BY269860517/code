package com.example.concurrent.test;

import java.util.*;

public class TreeTest3 {
    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode4);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        TreeTest3 treeTest3 = new TreeTest3();
        treeTest3.levelOrder(treeNode1);
    }

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Author by
     * @Description
     * @Date 12:21 2022/4/19
     * @Param [root]
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int curLevelSize = treeNodes.size();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = treeNodes.poll();
                levelList.add(node.getVal());
                if (node.getLeft() != null) {
                    treeNodes.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    treeNodes.offer(node.getRight());
                }

            }
            result.add(levelList);
        }
        print(result);
        return result;
    }


    public void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            if (!list.isEmpty()) {
                System.out.println(list.get(list.size() - 1));
            }
        }
    }


}

