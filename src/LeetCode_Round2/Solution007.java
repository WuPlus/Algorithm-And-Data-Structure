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
public class Solution007 {

    public int reverse(int x) {
        boolean negative = (x < 0);
        x = (negative) ? -x : x;
        int res = 0;
        while (x > 0) {
            int tmp = x % 10;
            if ((res >= Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10) || res > Integer.MAX_VALUE / 10) {
                return 0;
            } else {
                res = res * 10 + tmp;
                x /= 10;
            }
        }
        return (negative) ? -res : res;
    }

}
