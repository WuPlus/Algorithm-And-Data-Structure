/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class ConvertToTitle {

    public String convertToTitle(int n) {
        String result = "";
        int digit;
        while (n > 0) {
            digit = n % 26;
            n /= 26;
            if (digit == 0) {
                result = "Z" + result;
                n--;
            } else {
                result = (char) (digit + 64) + result;
            }
        }
        return result;
    }
}
