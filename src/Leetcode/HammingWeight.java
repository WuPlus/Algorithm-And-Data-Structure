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
public class HammingWeight {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            int bit = n % 2;
            if (bit == 1) {
                result++;
            }
            n = n / 2;
        }
        return result;
    }
}
