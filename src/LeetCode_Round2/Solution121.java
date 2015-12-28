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
public class Solution121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        int len = prices.length;
        int buy_day = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[buy_day]) {
                max = Math.max(max, prices[i] - prices[buy_day]);
            } else {
                buy_day = i;
            }
        }
        return max;
    }
}
