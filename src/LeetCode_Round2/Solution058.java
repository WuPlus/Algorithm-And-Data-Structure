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
public class Solution058 {

    public int lengthOfLastWord(String s) {
        int res = 0;
        s = s.trim();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return res;
            } else {
                res++;
            }
        }

        return res;
    }
}
