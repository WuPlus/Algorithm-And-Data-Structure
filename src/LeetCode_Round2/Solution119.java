/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = res.size() - 1; j >= 1; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
            res.add(1);
        }

        return res;
    }
}
