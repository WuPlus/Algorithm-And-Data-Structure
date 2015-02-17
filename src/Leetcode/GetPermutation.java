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
public class GetPermutation {

    public static void main(String[] args) {
        GetPermutation gp = new GetPermutation();
        String s = gp.getPermutation(3, 4);
        System.out.println(s);
    }

    public String getPermutation(int n, int k) {
        String s = "";
        boolean[] markers = new boolean[n];
        Arrays.fill(markers, true);
        int [] fac = new int[n];
        fac[0] = 1;
        for(int i=1;i<n;i++){
            fac[i] = fac[i-1]*i;
        }
        while (n > 0) {
            int temp = fac[n-1];
            int no = k / temp + 1;
            k = k % temp;
            if (k == 0) {
                int digit = findN(markers, no-1);
                s = s + digit + max(markers);
                return s;
            } else {
                int digit = findN(markers, no);
                s = s + "" + digit;
            }
            n--;
        }
        return s;
    }


    public int findN(boolean[] b, int n) {
        int i = 0;
        while (n > 0) {
            if (b[i] == true) {
                n--;
            }
            i++;
        }
        b[i - 1] = false;
        return i;
    }

    public String max(boolean[] b) {
        String s = "";
        for (int i = b.length - 1; i >= 0; i--) {
            if (b[i] == true) {
                s += (i + 1);
            }
        }
        return s;
    }
}
