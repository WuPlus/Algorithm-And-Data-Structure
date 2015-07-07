/*
 Given an integer, write a function to determine if it is a power of two.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class IsPowerOf2 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        String binStr = Integer.toBinaryString(n);
        for (int i = 1; i < binStr.length(); i++) {
            if (binStr.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
