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
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList();
        LinkedList<TreeNode> queue = new LinkedList();
        if (root == null) {
            return res;
        }
        queue.add(root);
        queue.add(null);
        List<Integer> level = new LinkedList();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                res.addFirst(level);
                level = new LinkedList();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return res;
    }
}
