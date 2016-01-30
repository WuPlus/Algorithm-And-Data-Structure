/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package Company.Zappos;

import java.util.*;

/**
 *
 * @author Wu
 */
public class Solution1 {

    Set<String> set = new HashSet();

    public int subPalindromeCount(String s) {
        int len = s.length();
        int res = 0;
        if (len < 2) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            int tmp = helper(s, i, i);
            res += tmp;
            int tmp2 = helper(s, i, i + 1);
            res += tmp2;
        }
        return res;
    }

    int helper(String s, int i, int j) {
        int len = s.length();
        int res = 0;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            if (set.add(s.substring(i, j+1))) {
                res++;
            }
            i--;
            j++;
        }

        return res;
    }
    
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.subPalindromeCount("aabaa"));
    }
}
