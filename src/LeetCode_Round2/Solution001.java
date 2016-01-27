/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package LeetCode_Round2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class Solution001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i + 1;
                res[0] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i + 1);
            }
        }
        return res;
    }
}
