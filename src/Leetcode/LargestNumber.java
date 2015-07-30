/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Wu
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int size = nums.length;
        PriorityQueue<String> pq = new PriorityQueue<>(size, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                // TODO Auto-generated method stub
                System.out.println(s1 + " compares with " + s2);
               
                int size1 = s1.length();
                int size2 = s2.length();
                int max;
                if(size1 > size2){
                    while(size1%size2 != 0){
                        s1+=s1.charAt(0);
                        size1++;
                    }
                    max = size1;
                }else{
                    while(size2%size1 != 0){
                        s2+=s2.charAt(0);
                        size2++;
                    }
                    max = size2;
                }
                int i = 0;
                while(i < max){
                    if(s1.charAt(i%size1) > s2.charAt(i%size2)){
                        System.out.println("-(-1)-");
                        return -1;
                    }else if(s1.charAt(i%size1) < s2.charAt(i%size2)){
                        System.out.println("-(1)-");
                        return 1;
                    }
                    i++;
                }
                return 0;
            }
        });
        for(int i = 0; i<size;i++){
            pq.add(nums[i]+"");
        }
        String result = "";
        while(!pq.isEmpty()){
            result += (pq.poll());
        }
        if(result.charAt(0) == '0')
            result = "0";
        return result;
    }
}
