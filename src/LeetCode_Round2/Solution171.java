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
public class Solution171 {

    public int titleToNumber(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res = res * 26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
