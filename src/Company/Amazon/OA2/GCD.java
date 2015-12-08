/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon.OA2;

/**
 *
 * @author Wu
 */
public class GCD {

    public int solution(int[] input) {
        int len = input.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int gcd = input[0];
        for (int i = 1; i < len; i++) {
            gcd = gcd(gcd, input[i]);
        }
        return gcd;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
