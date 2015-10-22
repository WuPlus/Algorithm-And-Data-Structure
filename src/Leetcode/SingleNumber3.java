/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class SingleNumber3 {
    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int [] result = new int[2];
        for(int i = nums.length-1; i >= 0; i--){
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
                System.out.println("remove "+ nums[i] + " size: " + map.size());
            }else{
                map.put(nums[i],1);
                System.out.println("put "+ nums[i] + " size: " + map.size());
            }
        }
        System.out.println("size="+map.size());
        Iterator<Integer> i = map.keySet().iterator();
        int count = 0;
        while(i.hasNext()){
            result[count] = i.next();
            count++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int [] input = {0,0,1,2};
        int [] result = singleNumber(input);
        System.out.println(Arrays.toString(result));
    }
}
