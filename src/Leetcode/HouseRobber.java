/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is 
that adjacent houses have security system connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class HouseRobber {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int rob(int[] nums) {
        int length = nums.length;
        return rob(nums,length-1,length);
    }
    
    public int rob(int[] nums, int index, int length){
        if(index >= 0){
            if(!map.containsKey(index)){
                map.put(index,Math.max(rob(nums,index-1,length),nums[index]+rob(nums,index-2,length)));
            }
            return map.get(index);
        }else
            return 0;
    }
}
