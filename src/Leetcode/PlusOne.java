/*
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
package Leetcode;

/**
 * @author Wu
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int sign = 0;
        if (digits[length - 1] + 1 == 10) {
            sign = 1;
            digits[length - 1] = 0;
            for (int i = length - 2; i >= 0; i--) {
                if (digits[i] + sign == 10) {
                    sign = 1;
                    digits[i] = 0;
                } else {
                    digits[i] += sign;
                    sign = 0;
                }
            }
        } else {
            digits[length - 1]++;
            return digits;
        }

        int[] result = null;
        if (digits[0] == 0 && sign == 1) {
            result = new int[length + 1];
            result[0] = 1;
            for (int i = 0; i < length; i++) {
                result[i + 1] = digits[i];
            }
        } else {
            return digits;
        }
        return result;

    }
}
