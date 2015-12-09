/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class DifferentWaysToAddParentheses {

    Map<String, List<Integer>> map = new HashMap();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            res.add(Integer.parseInt(input));
            return res;
        }
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String s1 = input.substring(0, i);
                String s2 = input.substring(i + 1, len);
                if (!map.containsKey(s1)) {
                    map.put(s1, diffWaysToCompute(s1));
                }
                if (!map.containsKey(s2)) {
                    map.put(s2, diffWaysToCompute(s2));
                }
                List<Integer> l1 = map.get(s1);
                List<Integer> l2 = map.get(s2);
                for (int j : l1) {
                    for (int k : l2) {
                        if (c == '-') {
                            res.add(j - k);
                        } else if (c == '+') {
                            res.add(j + k);
                        } else {
                            res.add(j * k);
                        }
                    }
                }
            }
        }
        return res;
    }
}
