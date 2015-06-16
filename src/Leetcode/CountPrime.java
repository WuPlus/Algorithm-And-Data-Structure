/*
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 */
package Leetcode;

import java.util.BitSet;

/**
 *
 * @author Wu
 * @Reference https://leetcode.com/discuss/33528/accepted-java-code-with-bitset
 */
public class CountPrime {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        BitSet set = new BitSet(n);
        set.set(0, 2);

        for (int i = 2; i < n; i++) {
            if (!set.get(i)) {
                for (int j = i*2; j < n; j+=i) {
                    set.set(j);
                }    
            }

        }

        return n-set.cardinality();
    }
}
