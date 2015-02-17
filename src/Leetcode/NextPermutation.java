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
public class NextPermutation {
    public static void main(String[] args) {
        int [] n = {1,3,2};
        nextPermutation(n);
    }
    public static void nextPermutation(int[] num) {
        int length = num.length;
        int i = num.length - 1;
        if ( i == 0){
            return;
        }
        while(i >= 1){
            if(num[i] > num[i-1]){
                int temp = num[i-1];
                num[i-1] = num[length-1];
                num[length-1] = temp;
                printArray(num);
                Arrays.sort(num, 1, 3);
                printArray(num);
                return;
            }
            i--;
        }
        Arrays.sort(num);
    }
    
    public static void printArray(int []num){
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
        System.out.println("");
    }
}
