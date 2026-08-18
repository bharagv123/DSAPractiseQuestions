package org.example;

public class DiameterOfABinaryTree {
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

        maximumDiameter(root);
    }

    private static void maximumDiameter(TreeNode root) {
        int[] maxd = new int[1];
        calculatediameter(root, maxd);
        System.out.println(maxd[0]);
    }

    private static int calculatediameter(TreeNode root, int[] maxd) {
        if (root==null) return 0;
        int lmax = calculatediameter(root.left,maxd);
        int rmax = calculatediameter(root.right,maxd);
        maxd[0] = Math.max(maxd[0],lmax+rmax+1);
        return 1 + Math.max(lmax,rmax);
    }
}
