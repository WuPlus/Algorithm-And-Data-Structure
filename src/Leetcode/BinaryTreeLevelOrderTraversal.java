/*
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
package Leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Wu
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        int count = 1;
        while (queue.size() != 0) {
            int next = 0;
            List<Integer> row = new LinkedList<Integer>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                row.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    next++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    next++;
                }
            }
            count = next;
            list.add(row);
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
