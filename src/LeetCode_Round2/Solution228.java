/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class Solution228 {

    public List<String> summaryRanges(int[] nums) {
        LinkedList<String> res = new LinkedList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = 0;
        int len = nums.length;
        int i = 1;
        for (; i < len; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == i - 1) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    res.add(nums[start] + "->" + nums[i - 1]);
                }
                start = i;
            }
        }
        if (start == i - 1) {
            res.add(String.valueOf(nums[start]));
        } else {
            res.add(nums[start] + "->" + nums[i - 1]);
        }
        return res;
    }
}
