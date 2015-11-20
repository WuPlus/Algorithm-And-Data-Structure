/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class MinimalWindowSubstring {

    static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        int t_length = t.length();
        int s_length = s.length();
        if(t_length > s_length) return "";
        
        for(int i = 0; i < t_length; i++){
            Character c = t.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int size = map.size();
        
        int p1 = 0;
        int p2 = 0;
        int start = 0;
        int end = s_length - 1;
        int r_length = Integer.MAX_VALUE;
        
        while(p2 < s_length){
            Character c = s.charAt(p2);
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;
                map.put(c, count);
                if(count == 0){
                    size--;
                }
                if(size == 0){
                    start = p1;
                    end = p2;
                    r_length = Math.min(r_length,end-start);
                    while(p1 <= p2){
                        Character c2 = s.charAt(p1);
                        if(map.containsKey(c2)){
                            int count2 = map.get(c);
                            count2++;
                            map.put(c2, count2);
                            if(count2 == 1){
                                size++;
                                break;
                            }
                        }else{
                            start = p1+1;
                            r_length = Math.min(r_length,end-start);
                        }
                        p1++;
                    }
                }
            }
            p2++;
        }
        
        if(r_length == Integer.MAX_VALUE)
            return "";
        return s.substring(start,end+1);
    }
    
    public static void main(String[] args) {
        minWindow("bdab","ab");
    }
}
