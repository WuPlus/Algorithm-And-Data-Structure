/*
 Reverse bits of a given 32 bits unsigned integer.
 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += ((n >>> i) << 31) >>> i;
        }
        return result;
    }
}
