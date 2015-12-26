/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.BitSet;

/**
 *
 * @author Wu
 */
public class Solution204 {

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        BitSet bs = new BitSet(n);
        bs.set(0);
        bs.set(1);
        for (int i = 2; i * i < n; i++) {
            if (bs.get(i)) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                bs.set(j);
            }
        }
        return n - bs.cardinality();
    }
}
