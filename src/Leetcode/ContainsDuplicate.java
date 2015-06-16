/*
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 */
package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Wu
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
