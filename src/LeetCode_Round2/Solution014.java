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
public class Solution014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            while (!strs[i].startsWith(res)) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
