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
public class Solution169 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int count = 1;
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            if (result == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = nums[i];
                    count = 1;
                }
            }
        }
        return result;
    }
}
