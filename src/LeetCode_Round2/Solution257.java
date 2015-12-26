/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList();
        if (root == null) {
            return res;
        }
        helper(root, res, "");
        return res;
    }

    public void helper(TreeNode root, List<String> res, String current) {
        if (root.left != null) {
            helper(root.left, res, current + "->" + root.val);
        }
        if (root.right != null) {
            helper(root.right, res, current + "->" + root.val);
        }
        if (root.left == null && root.right == null) {
            String tmp = current + "->" + root.val;
            res.add(tmp.substring(2, tmp.length()));
        }
    }
}
