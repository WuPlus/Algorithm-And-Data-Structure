/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.HashMap;

/**
 *
 * @author Wu
 */
public class LengthOfLongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = lengthOfLongest(s.substring(i,s.length()));
            if(x > r){
                r = x;
            }
        } 
       return r;
    }
    
    public int lengthOfLongest(String s){
        HashMap<String, Integer> ht = new HashMap<String, Integer>();
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            String st = s.charAt(i) + "";
            if (ht.containsKey(st)) {
                return r;
           }else{
               r++;
               ht.put(s.charAt(i)+"",i);
           }
       } 
       return r;
    }
}
