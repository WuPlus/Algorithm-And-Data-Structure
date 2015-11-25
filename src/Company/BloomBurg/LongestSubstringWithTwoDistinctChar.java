/*
 找字符串s的最长只含有两个字符的子字符串
 */
package Company.BloomBurg;

/**
 *
 * @author Wu
 */
public class LongestSubstringWithTwoDistinctChar {

    public static int longestSubstringTwoDistinct(String s) {
        //O(n)
        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) {
                continue;
            }
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - i, maxLen);
                i = j + 1;
            }
            j = k - 1;
        }
        return Math.max(s.length() - i, maxLen);
    }
}
