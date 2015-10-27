/*
 * Totalpass of an element x in array A is defined as the number of elements which is larger than
 * element x. Given an array A, find the maximun totalpass of this array
 */
package Company.Google;

/**
 *
 * @author Wu
 */
public class Total_Pass {

    public static int max_total_pass(int[] a) {
        int max_count = 0;
        int min_value = Integer.MAX_VALUE;
        int min_value_count = 0; //number of current min value
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (a[i] > min_value) {
                max_count++;
            } else if (a[i] == min_value) {
                min_value_count++;
            } else {
                min_value = a[i];
                max_count += min_value_count;
                min_value_count = 1;
            }
        }
        return max_count;
    }

    public static int max_total_pass2(int[] a) {
        int min = a[0];
        int low = 0;
        int high = a.length;
        while (low < high - 1) {
            int middle = high - (high - low) / 2;
            if (a[middle] > min) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return a.length - high;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 3, 5, 6, 7, 1, 2, 4};
        int [] b = {1, 1, 2, 2, 3, 4, 5, 6};
        int res = max_total_pass(a);
        int res2 = max_total_pass2(b);
        System.out.println(res2);
    }
}
