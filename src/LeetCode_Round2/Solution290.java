/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.*;

/**
 *
 * @author Wu
 */
public class Solution290 {

    public boolean wordPattern(String pattern, String str) {
        Map map = new HashMap();
        String[] strs = str.split(" ");
        int len = pattern.length();
        if (len != strs.length) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(strs[i], i))) {
                return false;
            }
        }
        return true;
    }
}
