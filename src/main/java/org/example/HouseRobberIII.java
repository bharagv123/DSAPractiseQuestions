package org.example;


public class HouseRobberIII {
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
        int[] res = rob(root);
        System.out.println(Math.max(res[0],res[1]));

    }

    private static int[] rob(TreeNode root) {
        if(root==null) return new int[]{0,0};

        int[] left = rob(root.left);
        int[] right = rob(root.right);

        int withRoot = root.val + left[1] + right[1];
        int skipRoot = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[]{withRoot,skipRoot};
    }
}
