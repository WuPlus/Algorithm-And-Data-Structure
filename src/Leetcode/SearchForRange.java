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
public class SearchForRange {

    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return new int [] {-1,-1};
        if(length == 1 && nums[0] == target) 
            return new int [] {0,0};
        if(length == 1 && nums[0] == target)
            return new int [] {-1,-1};
        int low = 0,high = length - 1;
        double target_low = target - 0.5;
        double target_high = target + 0.5;
        while(low < high - 1){
            int mid = low + (high-low)/2;
            if (nums[mid] > target_low) high = mid;
            else low = mid;
        }
        int start = nums[low] == target?low : low+1;
        System.out.println("start = "+start);
        low = 0;
        high = length - 1;
        while(low < high - 1){
            int mid = low + (high-low)/2;
            System.out.println("mid = "+mid+" low ="+low+" high ="+high);
            if (nums[mid] > target_high) high = mid;
            else low = mid;
        }
        System.out.println("high = "+high);
        int end = nums[high] == target ? high : high - 1;
        System.out.println("end = "+end);
        if(end - start < 0){
            return new int [] {-1,-1};
        }else {
            return new int [] {start,end};
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,2,3};
        String res = Arrays.toString(searchRange(nums, 0));
        System.out.println(res);
    }
}
