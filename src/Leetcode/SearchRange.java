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
public class SearchRange {
    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int [] input = new int[] {1,2,4,6,8,20};
        int [] output = sr.searchRange(input, 11);
        System.out.println(Arrays.toString(output));
    }
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int [] result;
        if(length == 0){
            result = new int[] {-1, -1};
            return result;
        }
        if(length == 1) {
            if(nums[0] == target)
                result = new int[] {0, 0};
            else
                result = new int[] {-1, -1};
            return result;
        }
        if(nums[0] > target || nums[length-1] < target) {
            result = new int[] {-1, -1};
            return result;
        }
        
        int start = 0;
        int end = length-1;
        int middle = (start+end)/2;;
        while((end - start) != 1){
            if(nums[middle] > target){
                end = middle;
            }else if (nums[middle] < target){
                start = middle;
            }else{
                if(middle+1 < length){
                    result = new int[] {middle,middle};
                }else{
                    result = new int[] {-1,-1};
                }
                return result;
            }
            middle = (start+end)/2;
        }
        if(middle+1 < length){
            result = new int[] {middle,middle+1};
        }else{
            result = new int[] {-1,-1};
        }
        return result;
    }
}
