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
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
