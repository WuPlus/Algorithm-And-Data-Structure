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
public class Solution198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] rob = new int[len];
        int[] not_rob = new int[len];
        rob[0] = nums[0];
        not_rob[0] = 0;

        for (int i = 1; i < len; i++) {
            rob[i] = not_rob[i - 1] + nums[i];
            not_rob[i] = Math.max(not_rob[i - 1], rob[i - 1]);
        }

        return Math.max(rob[len - 1], not_rob[len - 1]);
    }
}
