/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.BloomBurg;

/**
 *
 * @author Wu
 */
public class MaximumSubarray {
    static int maxSubarray(int [] input){
        int result = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for(int i : input){
            cur = Math.max(cur+i, i);
            result = Math.max(result, cur);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int [] input = {1,1,2,-4,5,8,-9};
        System.out.println(maxSubarray(input));
    }
}
