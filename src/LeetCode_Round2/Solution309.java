/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution309 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int[] hold = new int[len];
        int[] unhold = new int[len];
        hold[0] = -prices[0];
        unhold[0] = 0;
        hold[1] = Math.max(hold[0], -prices[1]);
        unhold[1] = Math.max(unhold[0], hold[0] + prices[1]);

        for (int i = 2; i < len; i++) {
            hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
        }
        return unhold[len - 1];
    }
}
