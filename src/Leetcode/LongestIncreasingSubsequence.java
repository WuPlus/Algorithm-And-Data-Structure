/*
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 */
package Leetcode;

import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class LongestIncreasingSubsequence {

    /**
     * classic DP Time Complexity O(N^2) Space Complexity O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int lis_length = 0;
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lis_length = Math.max(lis_length, dp[i]);
        }
        return lis_length;
    }

    /**
     * find the position where target were inserted in order.
     *
     * @param input
     * @param size
     * @param target
     * @return
     */
    static int binary_search(int[] input, int size, int target) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (input[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * Time(O(N*LogN) Space(N) Referred form http://www.felix021.com/blog/read.php?1587
     *
     * @param nums
     * @return
     */
    static int lengthOfLISWithBinarySerch(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int lis_length = 0;
        for (int i = 0; i < length; i++) {
            int insert_position = binary_search(dp, lis_length, nums[i]);
            System.out.println(insert_position);
            if (insert_position < lis_length && dp[insert_position] > nums[i]) {
                dp[insert_position] = nums[i];
            } else if (insert_position == lis_length) {
                dp[insert_position] = nums[i];
                lis_length++;
            }
            System.out.println(Arrays.toString(dp));
        }

        return lis_length;
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence.lengthOfLISWithBinarySerch(input);
    }

}
