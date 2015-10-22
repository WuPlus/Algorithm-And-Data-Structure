/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        int days = prices.length;
        int buy_in_day = 0;
        int max_profit = 0;
        int current_max_profit = 0;
        for(int i = 1; i < days; i++){
            if(prices[i] > prices[i-1])
                current_max_profit = prices[i]-prices[buy_in_day];
            else{
                buy_in_day = i;
                max_profit += current_max_profit;
                current_max_profit = 0;
            }
        }
        return max_profit+current_max_profit;
    }
    
    public static void main(String[] args) {
        int[] prices = {6,1,3,2,4,7};
        System.out.println(maxProfit(prices));
    }
}
