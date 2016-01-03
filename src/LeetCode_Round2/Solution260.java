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
public class Solution260 {

    /**
     * Explanation From Discussion
     *
     * In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we
     * need to find. Note that since the two numbers are distinct, so there must be a set bit (that
     * is, the bit with value '1') in the XOR result. Find out an arbitrary set bit (for example,
     * the rightmost set bit).
     *
     * In the second pass, we divide all numbers into two groups, one with the aforementioned bit
     * set, another with the aforementinoed bit unset. Two different numbers we need to find must
     * fall into the two distinct groups. XOR numbers in each group, we can find a number in either
     * group.
     */
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }
        diff &= -diff;
        int[] res = new int[]{0, 0};
        for (int i : nums) {
            if ((i & diff) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
