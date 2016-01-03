/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package LeetCode_Round2;

import java.util.*;

/**
 *
 * @author Wu
 */
public class Solution229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int tmp1 = nums[0], tmp2 = nums[0], count1 = 0, count2 = 0;
        int length = nums.length;
        for (int i : nums) {
            if (i == tmp1) {
                count1++;
            } else if (i == tmp2) {
                count2++;
            } else if (count1 == 0) {
                tmp1 = i;
                count1++;
            } else if (count2 == 0) {
                tmp2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == tmp1) {
                count1++;
            } else if (i == tmp2) {
                count2++;
            }
        }
        if (count1 > length / 3) {
            res.add(tmp1);
        }
        if (count2 > length / 3) {
            res.add(tmp2);
        }
        return res;
    }
}
