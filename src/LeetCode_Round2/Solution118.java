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
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if (numRows == 0) {
            return result;
        }
        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> l = new ArrayList();
            List<Integer> ll = result.get(i - 1);
            l.add(1);
            for (int j = 0; j < ll.size() - 1; j++) {
                l.add(ll.get(j) + ll.get(j + 1));
            }
            l.add(1);
            result.add(l);
        }

        return result;
    }
}
