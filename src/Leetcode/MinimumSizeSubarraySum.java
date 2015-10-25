/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        int slow = 0, quick = 0;
        int sum = 0;
        int res = nums.length + 1;
        int _length = nums.length;
        while(quick < _length && slow <= quick){
            if(sum < s){
                sum += nums[quick];
                quick++;
            }else{
                res = Math.min(res, quick-slow);
                sum -= nums[slow];
                slow++;
            }
        }
        while(sum >= s && slow < _length && quick == _length){
            res = Math.min(res, quick-slow);
            sum -= nums[slow];
            slow++;
        }
        return (res == _length + 1)?0:res;
    }
    
    public static void main(String[] args) {
        int [] input  = {5,1,3 ,5,10,7,4,9,2,8};
        MinimumSizeSubarraySum.minSubArrayLen(15, input);
    }
}
