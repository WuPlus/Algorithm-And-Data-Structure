/*
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class strStr {

    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int stackLength = haystack.length();
        if (needleLength == 0) {
            return 0;
        }
        int hash = needle.hashCode();
        for (int i = 0; i <= stackLength - needleLength; i++) {
            if (hash == haystack.substring(i, i + needleLength).hashCode()) {
                return i;
            }
        }
        return -1;
    }
}
