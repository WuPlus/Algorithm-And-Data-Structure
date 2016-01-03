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
            boolean b = false;
            for (int j = 0; j < length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    b = true;
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = b ? min : -1;
        }
        return dp[amount];
    }
}
