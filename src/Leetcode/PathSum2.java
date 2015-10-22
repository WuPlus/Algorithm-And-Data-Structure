/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import Util.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class PathSum2 {
    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return null;
        res = new LinkedList();
        LinkedList<Integer> list = new LinkedList();
        pathSum(root,sum,list);
        return res;
    }
    
    public void pathSum(TreeNode node, int sum, LinkedList<Integer> list){
        if(node.left == null && node.right == null && sum - node.val == 0){
            list.add(node.val);
            res.add(list);
        }else{
            list.add(node.val);
            if(node.left != null)
                pathSum(node.left, sum - node.val, (LinkedList<Integer>)list.clone());
            if(node.right != null)
                pathSum(node.right,sum - node.val, (LinkedList<Integer>)list.clone());
        }
    }
}
