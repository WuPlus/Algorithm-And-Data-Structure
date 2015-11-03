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
public class RangeBitWiseAnd {

    static int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int step = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            step++;
        }
        return m << step;
    }

    public static void main(String[] args) {
        RangeBitWiseAnd.rangeBitwiseAnd(4, 7);
    }
}
