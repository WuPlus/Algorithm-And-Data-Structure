/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import Util.TreeNode;

/**
 *
 * @author Wu
 */
public class SumRootToLeafNumber {
    //recursive version
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root,0);
    }
    
    public int sumNumbersHelper(TreeNode root, int previous){
        if(root == null) return 0;
        if(root.left == null&&root.right == null){
            return previous*10 + root.val;
        }
        return sumNumbersHelper(root.left,previous*10+root.val) + sumNumbersHelper(root.right,previous*10+root.val);
    }
}
