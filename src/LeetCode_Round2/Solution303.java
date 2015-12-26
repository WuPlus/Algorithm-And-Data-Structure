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
public class Solution303 {

    private int[] sums;

    public Solution303(int[] nums) {
        int len = nums.length;
        sums = new int[len + 1];
        sums[0] = 0;
        for (int i = 0; i < len; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
