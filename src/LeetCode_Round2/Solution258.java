/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution258 {
    
    /**
     * Using Loop
     * @param num
     * @return 
     */
    public int addDigits(int num) {
        while(num >= 10){
            int tmp = num;
            num = 0;
            while(tmp != 0){
                num += tmp%10;
                tmp /= 10;
            }
        }
        
        return num;
    }
    
    /**
     * Refer: https://en.wikipedia.org/wiki/Digital_root
     * @param num
     * @return 
     */
    public int addDigits2(int num) {
        return num - 9*((num-1)/9);
    }
}
