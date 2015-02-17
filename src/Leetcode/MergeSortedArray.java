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
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] A = new int [8];
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        A[3] = 5;
        A[4] = 6;
        int[] B = {3};
        merge(A, 5, B, 1);
        for (int i : A) {
            System.out.println(i);
        }
    }

    public static void merge(int A[], int m, int B[], int n) {
        int[] mergedArray = new int[m + n];
        int aIndex = 0, bIndex = 0;
        int mergedArrayIndex = 0;
        while (aIndex < m && bIndex < n) {
            if (A[aIndex] <= B[bIndex]) {
                mergedArray[mergedArrayIndex] = A[aIndex];
                aIndex++;
            } else {
                mergedArray[mergedArrayIndex] = B[bIndex];
                bIndex++;
            }
            mergedArrayIndex++;
            //System.out.println("mai="+mergedArrayIndex);
        }
        while (aIndex < m) {
            mergedArray[mergedArrayIndex] = A[aIndex];
            aIndex++;
            mergedArrayIndex++;
        }
        while (bIndex < n) {
            mergedArray[mergedArrayIndex] = B[bIndex];
            bIndex++;
            mergedArrayIndex++;
        }
        for (int i = 0; i < m + n; i++) {
            A[i] = mergedArray[i];
        }
    }
}
