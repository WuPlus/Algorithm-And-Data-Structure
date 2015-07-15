/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        List<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> heightqueue = new LinkedList<Integer>();
        queue.add(root);
        heightqueue.add(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            int height = heightqueue.remove(0);
            if (node.left != null) {
                queue.add(node.left);
                heightqueue.add(height + 1);
                list.set(height, node.val);
            }
            if (node.right != null) {
                queue.add(node.right);
                heightqueue.add(height + 1);
                list.set(height, node.val);
            }
        }
        return list;

    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
