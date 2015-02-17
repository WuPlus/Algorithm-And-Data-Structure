/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class HasPathSum {

    public static void main(String[] args) {
        HasPathSum hps = new HasPathSum();
        TreeNode t = new TreeNode(-2);
        TreeNode t2 = new TreeNode(-3);
        t.right = t2;
        System.out.println(hps.hasPathSum(t, -5));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            return hasPath(root, sum);
        }
    }

    public boolean hasPath(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            System.out.println("here->sum=" + sum);
            if (root.val == sum) {
                return true;
            } else {
                return false;
            }
        }
        int newsum = sum - root.val;
        if (root.left == null) {
            return hasPath(root.right, newsum);
        }
        if (root.right == null) {
            return hasPath(root.left, newsum);
        } else {
            return (hasPath(root.right, newsum) || hasPath(root.left, newsum));
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
