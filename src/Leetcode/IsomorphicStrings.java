/*
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character 
 while preserving the order of characters. No two characters may map to the same character 
 but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        for (int i = 0; i < length; i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
            } else {
                if (map1.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), s.charAt(i));
            } else {
                if (map2.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
