/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;
        char startChar, endChar;
        while (startPointer < endPointer) {
            while ((startPointer < endPointer) && !Character.isLetterOrDigit(s.charAt(startPointer))) {
                startPointer++;
            }
            while ((startPointer < endPointer) && !Character.isLetterOrDigit(s.charAt(endPointer))) {
                endPointer--;
            }
            startChar = Character.toLowerCase(s.charAt(startPointer));
            endChar = Character.toLowerCase(s.charAt(endPointer));
            if (startChar != endChar) {
                return false;
            }
            startPointer++;
            endPointer--;
        }
        return true;
    }
}
