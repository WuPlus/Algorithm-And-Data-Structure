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
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        res.add(1);
        for(int i = 0; i < rowIndex; i++){
            for(int j = 1; j <= i; j++){
                res.set(j, res.get(j-1)+res.get(j));
            }
            res.add(1);
        }
        return res;
    }
    
    public static void main(String[] args) {
        PascalTriangle2 p = new PascalTriangle2();
        System.out.println(p.getRow(2));
    }
}
