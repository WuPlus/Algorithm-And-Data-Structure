/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.*;

/**
 *
 * @author Wu
 */
public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet();
        int len = nums.length;
        int upper = Math.min(len, k);
        for (int i = 0; i < upper; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }

        for (int i = k; i < len; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            set.remove(nums[i - k]);
        }
        return false;
    }
}
