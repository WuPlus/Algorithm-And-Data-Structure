/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic.Sort;

/**
 *
 * @author Wu
 */
public class Merge_Sort {

    private int[] array;
    private int[] tempArr;
    private int length;

    public void merge_sort(int[] input) {
        this.array = input;
        this.length = input.length;
        this.tempArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            doMergeSort(start, middle);
            doMergeSort(middle + 1, end);
            merge(start, middle, end);
        }
    }

    private void merge(int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            tempArr[i] = array[i];
        }
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= end) {
            if (tempArr[i] <= tempArr[j]) {
                array[k] = tempArr[i];
                i++;
            } else {
                array[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempArr[i];
            k++;
            i++;
        }
    }
}
