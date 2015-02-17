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
public class EightQueen {

    public static int count;

    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) {
                return false;
            }
            if (Math.abs(q[i] - q[n]) == (n - i)) {
                return false;
            }
        }
        return true;
    }

    public static int enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
        return count;
    }

    public static void enumerate(int[] q, int n) {
        int N = q.length;
        if (n == N) {
            count++;
        } else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isConsistent(q, n)) {
                    enumerate(q, n + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        enumerate(8);
    }

}
