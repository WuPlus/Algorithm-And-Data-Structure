/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Wu
 */
public class Anagrams {
    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        String [] s = {"",""};
        a.anagrams(s);
    }
    public List<String> anagrams(String [] strs){
        int hashCode = -1;
        List<String> l = new ArrayList<>();
        HashMap<Integer,String> ht = new HashMap<>();
        for(String s: strs){
            char [] c = s.toCharArray();
            Arrays.sort(c);
            int sortedHashCode = Arrays.hashCode(c);
            if(ht.containsKey(sortedHashCode)){
                System.out.println("add one");
                hashCode = sortedHashCode;
                l.add(s);
            }else{
                System.out.println("put one");
                ht.put(sortedHashCode, s);
            }
        }
        l.add(ht.get(hashCode));
        return l;
    }
}
