
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.PocketGems;

import Basic.Tree.TreeTraversal;
import Util.TreeNode;
import java.util.HashMap;
import java.util.Map;
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
    static TreeNode tenaryToTree(String s) {
        Map<Integer, TreeNode> map = new HashMap();
        for (int i = 0; i < s.length(); i += 2) {
            map.put(i, new TreeNode(s.charAt(i)+""));
        }
        int i = 1, N = s.length();
        Stack<TreeNode> stack = new Stack();
        while (i < N) {
            if (i < N && s.charAt(i) == '?') {
                TreeNode p = map.get(i - 1);
                if (i - 2 > -1 && !stack.isEmpty() && s.charAt(i - 2) != ':') {
                    stack.peek().left = p;
                }
                stack.push(p);
                i += 2;
            } else {
                TreeNode top = stack.pop();
                TreeNode right = map.get(i + 1);
                top.right = right;
                if (i - 2 > -1 && s.charAt(i - 2) != ':') {
                    TreeNode left = map.get(i - 1);
                    top.left = left;
                }
                i += 2;
            }
        }
        return map.get(0);
    }

    public static void main(String[] args) {
        TreeNode t = TenaryToTree.tenaryToTree("a?b?c:d:e?f:g");
        TreeTraversal.preorder(t);
    }
}
