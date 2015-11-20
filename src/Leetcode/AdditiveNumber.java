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
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        for (int i = 1; i <= length - 2; i++) {
            long first = Long.parseLong(num.substring(0, i));
            for (int j = i + 1; j <= length - 1; j++) {
                if(num.charAt(i) == '0') break;
                long second = Long.parseLong(num.substring(i, j));
                if (helper(num, j, first, second)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(String num, int index, long first, long second) {
        int length = num.length();
        if (index == length) {
            return true;
        }
        if (num.charAt(index) == '0') {
            return false;
        }
        String sum = String.valueOf(first + second);
        if (num.substring(index, length).startsWith(sum)) {
            return helper(num, index + sum.length(), second, first + second);
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        AdditiveNumber an = new AdditiveNumber();
        System.out.println(an.isAdditiveNumber("1023"));
    }
}
