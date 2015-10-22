/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int _length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        for (int i = 0; i < _length; i++) {
            int sum = 0 - nums[i];
            int high = _length - 1;
            int low = i + 1;
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low + 1 < _length && nums[low] == nums[low+1])
                        low+=1;
                    while(high - 1 > low && nums[high] == nums[high-1])
                        high-=1;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
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
            while (i + 1 < _length && nums[i] == nums[i + 1]) {
                System.out.println("++");
                i += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> l = ts.threeSum(array);
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(i).size(); j++) {
                System.out.print(l.get(i).get(j) + "->");
            }
            System.out.println("");
        }
    }
}
