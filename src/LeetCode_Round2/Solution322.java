/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                int tmp = i - coins[j];
                if (tmp >= 0 && dp[tmp] != -1) {
                    min = Math.min(min, dp[tmp] + 1);
                }
            }
            dp[i] = (min != Integer.MAX_VALUE) ? min : -1;
        }
        return dp[amount];
    }
}
