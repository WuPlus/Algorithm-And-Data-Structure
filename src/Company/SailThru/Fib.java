/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.SailThru;

import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class Fib {

    static int[] fib(int n) {
        int[] result = new int[n];
        if (n == 0) {
            return result;
        }
        if (n > 0) {
            result[0] = 0;
        }
        if (n > 1) {
            result[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int [] re = fib(10);
        System.out.println(Arrays.toString(re));
    }
}
