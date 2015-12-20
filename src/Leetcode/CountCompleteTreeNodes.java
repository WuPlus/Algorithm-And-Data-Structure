/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import Util.TreeNode;

/**
 *
 * @author Wu
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0) {
            return 0;
        } else {
            if (height(root.right) == h - 1) {
                return (1 << h - 1) + countNodes(root.right);
            } else {
                return (1 << h - 2) + countNodes(root.left);
            }
        }
    }

    public int height(TreeNode root) {
        return (root == null) ? 0 : 1 + height(root.left);
    }
}
