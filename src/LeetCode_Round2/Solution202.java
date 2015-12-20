/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Wu
 */
public class Solution202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (n != 1) {
            if (!set.add(n)) {
                return false;
            } else {
                int tmp = 0;
                while (n != 0) {
                    tmp += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = tmp;
            }
        }
        return true;
    }
}
