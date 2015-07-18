/*
 * Given a string, find the length of the longest substring without repeating characters. 
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        if (size == 0) {
            return 0;
        }
        int start = 0;
        int maxlength = 0;
        int currentLength = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                currentLength++;
            } else {
                maxlength = Math.max(currentLength, maxlength);

                int previous = map.get(c);
                if (start <= previous) {
                    start = previous + 1;
                }
                currentLength = i - start + 1;
                map.put(c, i);
            }
            if (maxlength == 95) {
                return 95;
            }
        }
        maxlength = Math.max(currentLength, maxlength);
        return maxlength;
    }
}
