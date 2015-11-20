/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic.Tree;

import Util.TreeNode;

/**
 *
 * @author Wu
 */
public class BST {

    public TreeNode root;

    /**
     * Find the corresponding TreeNode to input val
     *
     * @param val
     * @return TreeNode which contains that val
     */
    public TreeNode find(int val) {
        return find(this.root, val);
    }

    private TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return find(root.left, val);
        } else {
            return find(root.right, val);
        }
    }

    /**
     * Add val to the binary search tree
     *
     * @param val
     * @return root of tree
     */
    public TreeNode add(int val) {
        if (this.root == null) {
            this.root = new TreeNode(val);
            return this.root;
        }
        return add(this.root, val);
    }

    private TreeNode add(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            root.left = add(root.left, val);
        } else {
            root.right = add(root.right, val);
        }
        return root;
    }

    /**
     * remove TreeNode whose value is val case 1: no such node case 2: it is leaf node -> delete it
     * case 3: it has only left child node -> delete it case 4: it has only right child node ->
     * delete it case 5: it has both left and right child nodes -> replace its value with the
     * minimal value on its right subtree, delete that minimal node recursively
     *
     * @param root
     * @param val
     * @return
     */
    public boolean remove(int value) {
        if (root == null) {
            return false;
        } else {
            if (root.val == value) {
                TreeNode auxRoot = new TreeNode(0);
                auxRoot.left = root;
                boolean result = root.remove(value, auxRoot);
                root = auxRoot.left;
                return result;
            } else {
                return root.remove(value, null);
            }
        }
    }
}
