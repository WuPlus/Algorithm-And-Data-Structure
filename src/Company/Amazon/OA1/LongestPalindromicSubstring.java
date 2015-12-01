/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon.OA1;

/**
 *
 * @author Wu
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String res = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            String tmp = helper(s, i, i);
            if (tmp.length() > res.length()) {
                res = tmp;
            }
            String tmp2 = helper(s, i, i + 1);
            if (tmp2.length() > res.length()) {
                res = tmp2;
            }
        }
        return res;
    }

    String helper(String s, int i, int j) {
        int len = s.length();
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
