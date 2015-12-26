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
public class Solution318 {

    public int maxProduct(String[] words) {
        int len = words.length;
        BitSet[] tmp = new BitSet[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = helper(words[i]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                BitSet bs1 = (BitSet) tmp[i].clone();
                BitSet bs2 = (BitSet) tmp[j].clone();
                bs1.and(bs2);
                if (bs1.cardinality() == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }

    public BitSet helper(String s1) {
        BitSet bs = new BitSet(26);
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            bs.set(s1.charAt(i) - 'a');
        }
        return bs;
    }
}
