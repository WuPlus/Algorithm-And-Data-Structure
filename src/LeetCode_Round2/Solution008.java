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
public class Solution008 {

    public int myAtoi(String str) {
        int res = 0;
        boolean negative = false;
        int len = str.length();
        int i = 0;
        for (; i < len && str.charAt(i) == ' '; i++) {
        }
        if (i < len && str.charAt(i) == '-') {
            negative = true;
            i++;
        }
        if (!negative && i < len && str.charAt(i) == '+') {
            negative = false;
            i++;
        }

        while (i < len && Character.isDigit(str.charAt(i))) {
            char c = str.charAt(i);
            if (res > 214748364) {
                return negative ? -2147483648 : 2147483647;
            }
            if (res == 214748364) {
                if (negative && c >= '8') {
                    return -2147483648;
                }
                if (!negative && c >= '7') {
                    return 2147483647;
                }
                res = res * 10 + (c - '1' + 1);
                break;
            }
            res = res * 10 + (c - '1' + 1);
            i++;
        }

        return negative ? -res : res;
    }
}
