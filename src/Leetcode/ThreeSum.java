/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null) {
            return list;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int length = nums.length;
        for (int i = 0; i < length - 1 && nums[i] <= 0; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                int rest = 0 - nums[i] - nums[j];
                if (rest < nums[j]) {
                    break;
                } else if (((rest > nums[j]) && (map.containsKey(rest))) || ((rest == nums[j]) && (map.get(rest) >= 2))) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(rest);
                    list.add(l);
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] array = {-1,0,1,2,-1,-4};
        List<List<Integer>> l = ts.threeSum(array);
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(i).size(); j++) {
                System.out.print(l.get(i).get(j)+"->");
            }
            System.out.println("");
        }
    }
}
