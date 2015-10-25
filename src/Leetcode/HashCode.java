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
public class HashCode {

    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        int length = key.length;
        long total = 0;
        long base = 1;
        for (int i = length - 1; i >= 0; i--) {
            total = total + pow(base, (long) key[i], HASH_SIZE);
            total %= HASH_SIZE;
            base = pow(33, base, HASH_SIZE);
        }
        return (int) total % HASH_SIZE;
    }

    public long pow(long a, long b, int HASH_SIZE) {
        return a * b % HASH_SIZE;
    }
}
