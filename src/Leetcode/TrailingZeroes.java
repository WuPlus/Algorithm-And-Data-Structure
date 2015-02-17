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
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n > 1){
            n/=5;
            result += n;
        }
        return result;
    }
}
