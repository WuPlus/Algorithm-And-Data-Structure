/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return rows;
        }
        if (numRows >= 1) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            rows.add(row);
        }
        if (numRows >= 2) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            row.add(1);
            rows.add(row);
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
            }
            row.add(1);
            rows.add(row);
        }
        return rows;
    }
}
