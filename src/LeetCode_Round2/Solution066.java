/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution066 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = (digits[len - 1] + 1) / 10;
        digits[len - 1] = (digits[len - 1] + 1) % 10;
        for (int i = len - 2; i >= 0; i--) {
            int tmp = digits[i];
            digits[i] = (digits[i] + carry) % 10;
            carry = (tmp + carry) / 10;
        }
        if (carry == 1) {
            int[] result = new int[len + 1];
            result[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }
}
