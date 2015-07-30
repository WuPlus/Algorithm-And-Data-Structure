/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.TreeSet;

/**
 *
 * @author Wu
 */
public class ContainDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if (length == 1 )return false;
        if (k <= 0) return false;
        TreeSet<Long> treeset = new TreeSet<Long>();

        for(int i=0;i<length;i++) {
            Long temp = new Long(nums[i]);
            Long lt = new Long(t);
            Long max = temp+lt;
            Long min = temp-lt;
            if ( treeset.floor(max) !=null && treeset.floor(max) >= min ) 
                return true;

            treeset.add(new Long(nums[i]));


            if (i >= k) {
                treeset.remove(new Long(nums[i-k]));
            }
        }

        return false;
    }
}
