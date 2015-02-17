/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String [] splits = s.split(" ");
        int length = splits.length;
        if(length == 0) return 0;
        else{
            return splits[length-1].length();
        }
    }
}
