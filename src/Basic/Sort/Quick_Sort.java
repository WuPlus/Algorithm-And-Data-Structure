/*
 * implementation of quick sort (in-place version)
 */
package Basic.Sort;

import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class Quick_Sort {

    int[] arr;

    public void quick_sort(int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] < pivot && left < right) {
                left++;
            }
            while (arr[right] > pivot && left < right) {
                right--;
            }
            swap(left, right);
        }
        if (arr[left] >= pivot) {
            swap(left, end);
        }else{
            left++;
        }
        quick_sort(start, left - 1);
        quick_sort(left + 1, end);
    }

    private void swap(int x, int y) {
        int temp = arr[y];
        arr[y] = arr[x];
        arr[x] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 33, 3, 5, 66, 7, 1, 4, 5, 2, 1, 111};
        Quick_Sort qs = new Quick_Sort();
        qs.arr = arr;
        qs.quick_sort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
