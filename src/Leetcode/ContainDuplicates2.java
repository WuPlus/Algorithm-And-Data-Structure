/*
 Given an array of integers and an integer k, find out whether there there are two distinct indices 
i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class ContainDuplicates2 {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        int length = nums.length;
        for(int i=0;i<length;i++){
            if(!map.containsKey(nums[i])&&map.size()<k){
                map.put(nums[i],1);
            }else if (!map.containsKey(nums[i])&&map.size() == k){
                map.remove(nums[i-k]);
                map.put(nums[i],1);
            }else if(map.containsKey(nums[i]))
                return true;
        }
        return false;
    }
}
