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
public class Solution268 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (len + 1) * len / 2 - sum;
    }
}
