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
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
    
    public TreeNode(char c){
        this.cv = c;
    }
}
