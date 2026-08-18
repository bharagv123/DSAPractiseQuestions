package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        maxLevelSum(root);
    }

    private static void maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int level=1;
        int answer = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int curSum = 0;
            TreeNode node;
            for (int i=0;i<size ;i++) {
                node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                curSum += node.val;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                answer = level;
            }
            level++;
        }
        System.out.println("level at which maximum sum occur : " + level);
        System.out.println("maximum sum at that level occur : " + maxSum);
    }
}
