/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class Solution299 {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int len = secret.length();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                if (!map.containsKey(s)) {
                    map.put(s, 0);
                }
                if (!map.containsKey(g)) {
                    map.put(g, 0);
                }
                if (map.get(s) < 0) {
                    cows++;
                }
                if (map.get(g) > 0) {
                    cows++;
                }
                map.put(s, map.get(s) + 1);
                map.put(g, map.get(g) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }
}
