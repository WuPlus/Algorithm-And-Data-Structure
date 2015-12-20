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
public class Solution191 {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += (n & 1);
            n = n >>> 1;
        }
        return result;
    }
}
