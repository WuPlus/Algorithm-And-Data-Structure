/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution205 {

    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < len; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
