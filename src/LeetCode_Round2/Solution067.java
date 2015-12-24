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
public class Solution067 {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            sb.insert(0, (a.charAt(i) + b.charAt(j) - 2 * '0' + carry) % 2);
            carry = ((a.charAt(i) + b.charAt(j) - 2 * '0') + carry) / 2;
            i--;
            j--;
        }
        while (i >= 0) {
            sb.insert(0, (a.charAt(i) - '0' + carry) % 2);
            carry = (a.charAt(i) - '0' + carry) / 2;
            i--;
        }
        while (j >= 0) {
            sb.insert(0, (b.charAt(j) - '0' + carry) % 2);
            carry = (b.charAt(j) - '0' + carry) / 2;
            j--;
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
