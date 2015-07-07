/*
 Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery 
 so that he will not get too much attention. This time, all houses at this place are arranged
 in a circle. That means the first house is the neighbor of the last one. Meanwhile, 
 the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house, 
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class HouseRubber2 {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        return Math.max(rob(nums, length - 2), nums[length - 1] + rob2(nums, length - 3));
    }

    public int rob(int[] nums, int index) {
        if (index >= 0) {
            if (!map.containsKey(index)) {
                map.put(index, Math.max(rob(nums, index - 1), nums[index] + rob(nums, index - 2)));
            }
            return map.get(index);
        } else {
            return 0;
        }
    }

    public int rob2(int[] nums, int index) {
        if (index > 0) {
            if (!map2.containsKey(index)) {
                map2.put(index, Math.max(rob2(nums, index - 1), nums[index] + rob2(nums, index - 2)));
            }
            return map2.get(index);
        } else {
            return 0;
        }
    }
}
