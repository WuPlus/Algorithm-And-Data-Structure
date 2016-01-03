/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Wu
 */
public class Solution179 {

    public String largestNumber(int[] nums) {
        String[] tmp = new String[nums.length];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            tmp[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(tmp, new Comparator<String>() {
            public int compare(String i1, String i2) {
                // TODO Auto-generated method stub
                return (i2 + i1).compareTo(i1 + i2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(s);
        }
        String s = sb.toString();
        if (s.charAt(0) == '0' && s.length() > 1) {
            return "0";
        }
        return s;
    }
}
