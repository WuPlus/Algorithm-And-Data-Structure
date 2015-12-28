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
public class Solution153 {

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
