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
public class HIndex {

    public static int hIndex(int[] citations) {
        int size = citations.length;
        int[] counts = new int[size + 1];

        for (int c : citations) {
            if (c >= size) {
                counts[size]++;
            } else {
                counts[c]++;
            }
        }
        System.out.println(Arrays.toString(counts));

        int higher_count = counts[size];
        for (int i = size; i >= 0; i--) {
            higher_count += counts[i];
            System.out.println(higher_count);
            if (i <= higher_count) {
                return i;
            }
        }

        return 0;

    }
    
    public static void main(String[] args) {
        int [] a = {0};
        hIndex(a);
    }
}
