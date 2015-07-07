/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 What if the BST is modified (insert/delete operations) often and 
 you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 Modify the TreeNode to 

 public class TreeNode {

 int val;
 TreeNode left;
 TreeNode right;
 int leftCount;
 int rightCount;

 TreeNode(int x) {
 val = x;
 }

 Update the leftCount and rightCount after each insert/delete Operation
 }
 */
package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class KthSmallest {

    List<Integer> list = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        ZXBL(root);
        return list.get(k - 1);
    }

    public void ZXBL(TreeNode root) {
        if (root != null) {
            ZXBL(root.left);
            list.add(root.val);
            ZXBL(root.right);
        }
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
