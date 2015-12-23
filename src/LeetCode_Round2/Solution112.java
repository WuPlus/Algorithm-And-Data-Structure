/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            return helper(root, sum);
        }
    }

    private boolean helper(TreeNode root, int sum) {
        if (root == null && sum == 0) {
            return true;
        } else if (root == null && sum != 0) {
            return false;
        } else if (root.left == null && root.right != null) {
            return helper(root.right, sum - root.val);
        } else if (root.left != null && root.right == null) {
            return helper(root.left, sum - root.val);
        } else {
            return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
        }
    }
}
