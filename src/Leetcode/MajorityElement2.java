/*
 Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 The algorithm should run in linear time and in O(1) space.
 */
package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Iterator<Integer> i = map.keySet().iterator();
        List<Integer> result = new ArrayList<Integer>();
        while (i.hasNext()) {
            int key = i.next();
            if (map.get(key) > length / 3) {
                result.add(key);
            }
        }
        return result;
    }
}
