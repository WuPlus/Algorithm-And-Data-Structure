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
public class Solution231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while ((n & 1) == 0) {
            n = n >>> 1;
        }
        return (n == 1);
    }
}
