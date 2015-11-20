/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Wu
 */
public class TreeNode {

    public int val;
    public char cv;
    public String sv;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(char c) {
        this.cv = c;
    }

    public TreeNode(String s) {
        this.sv = s;
    }

    public boolean remove(int value, TreeNode parent) {
        if (value < this.val) {
            if (left != null) {
                return left.remove(value, this);
            } else {
                return false;
            }
        } else if (value > this.val) {
            if (right != null) {
                return right.remove(value, this);
            } else {
                return false;
            }
        } else {
            if (left != null && right != null) {
                this.val = right.minValue();
                right.remove(this.val, this);
            } else if (parent.left == this) {
                parent.left = (left != null) ? left : right;
            } else if (parent.right == this) {
                parent.right = (left != null) ? left : right;
            }
            return true;
        }
    }

    private int minValue() {
        if (left == null) {
            return val;
        } else {
            return left.minValue();
        }
    }
}
