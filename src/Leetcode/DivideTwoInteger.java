/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class DivideTwoInteger {

    static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        boolean isNegative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNegative = true;
        }
        long divid = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        long res = 0;
        while (divid >= div) {
            long temp = div;
            long count = 1;
            while (divid >= temp) {
                divid = divid - temp;
                res += count;
                temp = temp << 1;
                count = count << 1;
            }
        }
        return isNegative ? (int)-res : (int)res;
    }
    
    public static void main(String[] args) {
        int r = divide(-2147483648,-1);
        System.out.println(r);
    }
}
