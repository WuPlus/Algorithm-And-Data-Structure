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
public class SingleNumber2 {
    public static int singleNumber(int[] nums) {
        int length = nums.length;
        int t1 = 0;
        int t2 = 0;
        for(int i = 0; i < length; i++){
            t1 = (t1^nums[i])|t2;
            t2 = t2^nums[i];
            System.out.println("t1 = "+t1 +" |t2 = "+t2);
        }
        return t1;
    }
    
    public static void main(String[] args) {
        int [] test = new int [] {1,1,1,2};
        System.out.println(singleNumber(test));
    }
}
