/*
 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class SummaryRange {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<String>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                end++;
            } else {
                if (start == end) {
                    result.add(nums[start] + "");
                } else {
                    result.add(nums[start] + "->" + nums[end]);
                }
                start = end = i + 1;
            }
        }
        if (start == end) {
            result.add(nums[start] + "");
        } else {
            result.add(nums[start] + "->" + nums[end]);
        }
        return result;
    }
}
