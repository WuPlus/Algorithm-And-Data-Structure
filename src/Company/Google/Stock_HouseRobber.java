/*
 * 可以无限买，但是必须隔N天买
 */
package Company.Google;

/**
 *
 * @author Wu
 */
public class Stock_HouseRobber {
    static int stock_houseRobber(int [] prices){
        int days = prices.length;
        int [] hold = new int[days];
        int [] unhold = new int[days];
        int max_profit = 0;
        if(days < 3)
            return max_profit;
        hold[0] = 0 - prices[0];
        hold[1] = 0 - prices[0];
        unhold[0] = 0;
        unhold[1] = 0;
        for (int i = 2; i < days; i++) {
            hold[i] = Math.max(hold[i-1], unhold[i-2] - prices[i]);
            unhold[i] = Math.max(unhold[i-1], hold[i-2] + prices[i]);
            max_profit = Math.max(max_profit, unhold[i]);
        }
        return max_profit;
    }
}
