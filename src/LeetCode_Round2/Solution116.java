/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.LinkedList;

/**
 *
 * @author Wu
 */
public class Solution116 {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        TreeLinkNode pre = null;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (pre != null) {
                pre.next = node;
            }
            pre = node;

            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
