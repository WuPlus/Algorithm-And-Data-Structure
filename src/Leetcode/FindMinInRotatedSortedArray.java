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
public class FindMinInRotatedSortedArray {
   public static int findMin(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length -1;
        while(low < high - 1) {
            int middle  = high - (high - low) / 2;
            System.out.println("high = "+high+" middle = "+middle + " low = "+low);
            if(nums[high] < nums[middle]) low = middle;
            if(nums[low] > nums[middle]) high = middle;
        }
        return nums[high];
    }
   
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,-3,-2,-1,0};
        System.out.println(findMin(nums));
        int low = 0,high = 0;
    }
}
