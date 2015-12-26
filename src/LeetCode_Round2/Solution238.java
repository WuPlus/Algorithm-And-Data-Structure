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
public class Solution238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        if (len == 0) {
            return res;
        }
        res[0] = nums[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i];
        }
        int tmp = 1;
        for (int i = len - 1; i >= 1; i--) {
            res[i] = res[i - 1] * tmp;
            tmp *= nums[i];
        }
        res[0] = tmp;
        return res;
    }
}
