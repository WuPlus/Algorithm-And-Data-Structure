/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.*;

/**
 *
 * @author Wu
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        int _length = nums.length;
        for (int i = 0; i < _length; i++) {
            int sum = target - nums[i];
            for (int j = i + 1; j < _length; j++) {
                int rest = sum - nums[j];
                int high = _length - 1;
                int low = j + 1;
                while (low < high) {
                    if (nums[low] + nums[high] == rest) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low + 1 < _length && nums[low] == nums[low + 1]) {
                            low += 1;
                        }
                        while (high - 1 > low && nums[high] == nums[high - 1]) {
                            high -= 1;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < rest) {
                        while (low + 1 < _length && nums[low] == nums[low + 1]) {
                            low += 1;
                        }
                        low++;
                    } else {
                        while (high - 1 > low && nums[high] == nums[high - 1]) {
                            high -= 1;
                        }
                        high--;
                    }
                }
                while (j + 1 < _length && nums[j] == nums[j + 1]) {
                    j += 1;
                }
            }
            while (i + 1 < _length && nums[i] == nums[i + 1]) {
                i += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = FourSum.fourSum(input, 0);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
