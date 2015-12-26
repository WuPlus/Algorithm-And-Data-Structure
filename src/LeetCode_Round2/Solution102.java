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
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new LinkedList();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add(list);
                list = new LinkedList();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
