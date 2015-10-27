/*
 * Implement Tree Traversal including preorder, inorder, postorder and level traversal
 * All the traversal methods are implemented in both recursive and iterative way
 */
package Basic;

import Util.TreeNode;
import java.util.*;

/**
 *
 * @author Wu
 */
public class TreeTraversal {

    /**
     * traverse tree in pre-order recursively
     *
     * @param root
     */
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.cv + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * traverse tree in in-order recursively
     *
     * @param root
     */
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.cv + " ");
        inorder(root.right);
    }

    /**
     * traverse tree in post-order recursively
     *
     * @param root
     */
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.cv + " ");
    }

    /**
     * traverse tree in pre-order iteratively
     *
     * @param root
     */
    public static void preorderIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.print(current.cv + " ");
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    /**
     * traverse tree in in-order iteratively
     *
     * @param root
     */
    public static void inorderIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.cv + " ");
                current = current.right;
            }
        }
    }

    /**
     * traverse tree in post-order iteratively
     *
     * @param root
     */
    public static void postorderIter(TreeNode root) {
        Set<TreeNode> set = new HashSet();
        Stack<TreeNode> stack = new Stack();
        TreeNode current;
        if (root != null) {
            stack.push(root);
        } else {
            return;
        }

        while (!stack.isEmpty()) {
            current = stack.peek();
            if (set.contains(current)) {
                System.out.print(current.cv + " ");
                stack.pop();
                continue;
            }
            if (current.right != null) {
                stack.push(current.right);
                set.add(current);
            }
            if (current.left != null) {
                stack.push(current.left);
                set.add(current);
            }
            if (current.left == null && current.right == null) {
                System.out.print(current.cv + " ");
                stack.pop();
            }

        }
    }

    /**
     * traverse tree in level order iteratively
     *
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.getFirst();
            if (node != null) {
                System.out.print(node.val);
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
    }

    /**
     * for test only
     *
     * @param args
     */
    public static void main(String[] args) {
        // Tree Structure
        //          a
        //         / \
        //        b   c
        //       / \
        //      d   f
        //       \ /
        //       e g

        TreeNode node1 = new TreeNode('a');
        TreeNode node2 = new TreeNode('b');
        TreeNode node3 = new TreeNode('c');
        TreeNode node4 = new TreeNode('d');
        TreeNode node5 = new TreeNode('e');
        TreeNode node6 = new TreeNode('f');
        TreeNode node7 = new TreeNode('g');

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node6;
        node4.right = node5;
        node6.left = node7;

        TreeTraversal.preorder(node1);
        //output a b d e f g c 
        System.out.println("");
        TreeTraversal.inorder(node1);
        //output d e b g f a c
        System.out.println("");
        TreeTraversal.postorder(node1);
        //output e d g f b c a
        System.out.println("");
        TreeTraversal.preorderIter(node1);
        System.out.println("");
        TreeTraversal.inorderIter(node1);
        System.out.println("");
        TreeTraversal.postorderIter(node1);
    }
}
