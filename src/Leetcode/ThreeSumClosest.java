/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int _length = nums.length;
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for(int i = 0; i < _length; i++){
            int sum = target - nums[i];
            int low = i + 1;
            int high = _length - 1;
            while(low < high){
                if(nums[low] + nums[high] == sum){
                    return target;
                }else if(nums[low] + nums[high] < sum){
                    res = (sum - nums[low] - nums[high]) > Math.abs(res-target)?res:nums[i] + nums[low] + nums[high];
                    low++;
                }else{
                    res = (nums[low] + nums[high] - sum) > Math.abs(res-target)?res:(nums[low] + nums[high] + nums[i]);
                    high--;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int [] a = {0,1,2};
        threeSumClosest(a,0);
    }
}
