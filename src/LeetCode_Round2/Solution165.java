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
public class Solution165 {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int max = Math.max(len1, len2);
        for (int i = 0; i < max; i++) {
            int tmp1 = (i < len1) ? Integer.parseInt(v1[i]) : 0;
            int tmp2 = (i < len2) ? Integer.parseInt(v2[i]) : 0;
            if (tmp1 > tmp2) {
                return 1;
            } else if (tmp1 < tmp2) {
                return -1;
            }
        }
        return 0;
    }
}
