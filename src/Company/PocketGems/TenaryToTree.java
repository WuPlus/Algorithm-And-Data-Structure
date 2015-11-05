/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.PocketGems;

import Basic.Tree.TreeTraversal;
import Util.TreeNode;
import java.util.Stack;

/**
 *
 * @author Wu
 */
public class TenaryToTree {
    /**
     * Transform a tenary expression to Tree Form
     * eg: a?b?c:d:e
     *       a
     *      / \
     *     b   e
     *    / \
     *   c  d
     * @param exp
     * @return 
     */
    static TreeNode tenaryToTree(String exp) {
        Stack<String> stack = new Stack();
        String[] temp = exp.split("\\?");
        int length = temp.length;
        if (length < 1) {
            return null; //illegal expression
        }
        for (int i = 0; i < length - 1; i++) {
            stack.push(temp[i]);
        }
        String[] temp2 = temp[length - 1].split(":");
        int length2 = temp2.length;
        if (length < 2) {
            return null; //illegal expression
        }
        TreeNode left = new TreeNode(temp2[0]);
        TreeNode right = new TreeNode(temp2[1]);
        TreeNode top = new TreeNode(stack.pop());
        top.left = left;
        top.right = right;
        for (int i = 2; i < length2; i++) {
            right = new TreeNode(temp2[2]);
            if (stack.isEmpty()) {
                return null; //illegal expression
            }
            TreeNode newTop = new TreeNode(stack.pop());
            newTop.left = top;
            newTop.right = right;
            top = newTop;
        }
        if (stack.isEmpty()) {
            return top;
        } else {
            return null;//illegal expression
        }
    }

    public static void main(String[] args) {
        TreeNode t = TenaryToTree.tenaryToTree("a?b?c:d:e");
        System.out.println(t == null);
        //TreeTraversal.preorder(t);
    }
}
