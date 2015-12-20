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
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        int[] set = new int[26];
        int len1 = s.length();
        int len2 = t.length();
        for (int i = 0; i < len1; i++) {
            set[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len2; i++) {
            set[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (set[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
