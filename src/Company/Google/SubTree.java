/*
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes
 * Create an algorithm to decide if T2 is a subtree of T1
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical
 * to T2. That is, if you cut off the tree at node n, the two trees would be identical.
 */


package Company.Google;

import Util.TreeNode;

/**
 *
 * @author Wu
 */
public class SubTree {

    boolean containTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        } else {
            return subTree(t1, t2);
        }
    }

    boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            //test if they are match
            return matchTree(t1, t2);
        }
        return (subTree(t1.left, t2) || subTree(t1.right, t2));
    }

    boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) { //both are empty
            return true; 
        }
        if (t1 == null || t2 == null) { //if one, not both, are empty
            return false;
        }

        if (t1.val != t2.val) {
            return false; //data does not match
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }
}
