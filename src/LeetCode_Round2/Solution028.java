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
public class Solution028 {

    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int needleLen = needle.length();
        if (needleLen == 0) {
            return 0;
        }
        for (int i = 0; i <= hayLen - needleLen; i++) {
            boolean b = true;
            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                return i;
            }
        }
        return -1;
    }
}
