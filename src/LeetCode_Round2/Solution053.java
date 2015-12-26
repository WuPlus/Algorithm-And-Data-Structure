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
public class Solution053 {

    public int maxSubArray(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int tmp = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (tmp > 0) {
                tmp = tmp + nums[i];
            } else {
                tmp = nums[i];
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}
