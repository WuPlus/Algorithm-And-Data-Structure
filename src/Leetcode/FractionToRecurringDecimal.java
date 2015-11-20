/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.*;

/**
 *
 * @author Wu
 */
public class FractionToRecurringDecimal {

    static String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        
        if((numerator > 0 && denominator < 0)||(numerator < 0 && denominator > 0))
            sb.append('-');
        int num = Math.abs(numerator);
        int den = Math.abs(denominator);
        
        int temp = num/den;
        int rest = num%den;
        if(rest == 0){
            sb.append(temp);
            return sb.toString();
        }
        
        Map<Integer,Integer> map = new HashMap();
        int index = 0;
        while(rest != 0){
            rest*=10;
            
            num = rest/den;
            if(!map.containsKey(rest)){
                sb.append(num);
                map.put(rest,index); 
                index++;
                rest = rest%den;
            }else{
                sb.insert(map.get(rest),"(");
                sb.append(")");
                break;
            }
        }
        sb.insert(0,'.');
        sb.insert(0,temp);
        return sb.toString();
        
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2147483647, 37));
    }
}
