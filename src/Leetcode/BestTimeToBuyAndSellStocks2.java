/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class BestTimeToBuyAndSellStocks2 {
    public static int maxProfit(int[] prices) {
        int days = prices.length;
        if(days == 0) return 0;
        int [] trends = new int [days+1];
        for(int i = 0; i < days - 1; i++){
            if(prices[i+1] > prices[i]) trends[i+1] = 1;
            else trends[i+1] = -1;
        }
        trends[0] = -1;
        trends[days] = -1;
        int buy_day = 0;
        int profit_sum = 0;
        System.out.println(Arrays.toString(trends));
        for(int i=0; i < days; i++){
            if(trends[i] == -1 && trends[i+1] == 1){
                buy_day = i;
            }
            if(trends[i] == 1 && trends[i+1] == -1){
                profit_sum += (prices[i] - prices[buy_day]);
            }
        }
        return profit_sum;
    }
    
    public static void main(String[] args) {
        int [] prices = {2,1,2,1,0,0,1};
        maxProfit(prices);
    }
}
