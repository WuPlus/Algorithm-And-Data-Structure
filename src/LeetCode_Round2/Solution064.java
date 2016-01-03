/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution064 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int[] dp = new int[width];
        dp[0] = grid[0][0];
        for (int i = 1; i < width; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[width - 1];
    }
}
