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
public class IsSymmetric {
    
    public boolean isSymmetricIterative(TreeNode root) {
        return false;
    }
    
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetricRecursive(root.left, root.right);
        }
    }

    public boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return (isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left));
            }
        }
    }

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
