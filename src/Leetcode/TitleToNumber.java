/*
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        int length = s.length();
        int result = 0;
        int j = 1;
        for(int i = length-1;i>=0;i--){
            result+=((s.charAt(i))-64)*j;
            j*=26;
        }
        return result;
    }
}
