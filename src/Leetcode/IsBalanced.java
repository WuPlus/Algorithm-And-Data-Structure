/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        Depth depth = new Depth();
        return isBalance(root, depth);
    }

    public boolean isBalance(TreeNode node, Depth d) {
        if (node == null) {
            d.height = 0;
            return true;
        }
        Depth right = new Depth();
        Depth left = new Depth();
        if (isBalance(node.left, left) && isBalance(node.right, right)) {
            int diff = left.height - right.height;
            if (diff <= 1 && diff >= -1) {
                d.height = left.height > right.height ? (left.height + 1) : (right.height + 1);
                return true;
            }
        }
        return false;
    }

    public class Depth {

        int height;
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
