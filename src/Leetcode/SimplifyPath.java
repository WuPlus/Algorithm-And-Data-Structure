/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Wu
 */
public class SimplifyPath {
    static String simplifyPath(String path) {
        String [] tmp = path.split("/");
        System.out.println(Arrays.toString(tmp));
        Stack<String> stack = new Stack();
        for(String s: tmp){
            if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else if(s.equals(".")){
                continue;
            }else{
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,'/');
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SimplifyPath.simplifyPath("/...");
    }
}
