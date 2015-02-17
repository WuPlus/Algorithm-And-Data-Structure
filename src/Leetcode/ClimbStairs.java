/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class ClimbStairs {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int climbStairs(int n) {
        if(n == 1) return 1;
        else if(n == 2) return 2;
        else {
            if(!map.containsKey(n))
                map.put(n,climbStairs(n-1)+climbStairs(n-2));
            return map.get(n);
        }
    }
}
