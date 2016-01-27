/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package Company.BloomBurg;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Wu
 */
public class TwoSumUnique {

    public int twoSumUnique(int[] input, int target) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i : input) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }

        for (int i : input) {
            if (i + i < target && map.containsKey(target - i)) {
                count++;
            } else if (i + i == target && map.get(i) >= 2) {
                count++;
            }
        }

        return count;

    }

    public int twoSumUnique2(int[] input, int target) {
        Arrays.sort(input);
        int count = 0;
        int length = input.length;
        int low = 0;
        int high = length - 1;
        while (low < high) {
            if (input[low] + input[high] == target) {
                count++;
                while (low + 1 < length && input[low] == input[low + 1]) {
                    low += 1;
                }
                while (high - 1 > low && input[high] == input[high - 1]) {
                    high -= 1;
                }
                low++;
                high--;
            } else if (input[low] + input[high] < target) {
                while (low + 1 < length && input[low] == input[low + 1]) {
                    low += 1;
                }
                low++;
            } else {
                while (high - 1 > low && input[high] == input[high - 1]) {
                    high -= 1;
                }
                high--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoSumUnique tsu = new TwoSumUnique();
        int c = tsu.twoSumUnique2(new int[]{3, 3, 3, 3, 4, 5}, 6);
        System.out.println(c);
    }
}
