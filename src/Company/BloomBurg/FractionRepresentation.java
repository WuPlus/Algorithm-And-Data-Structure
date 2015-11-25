/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.BloomBurg;

/**
 *
 * @author Wu
 */
public class FractionRepresentation {

    String fractionRepresentation(int a, int b) {
        if(a == 0) return "0";
        int gcd = gcd(a, b);
        return (a / gcd) + "/" + (b / gcd);
    }

    /**
     * 辗转相除法求GCD
     *
     * @param a
     * @param b
     * @return
     */
    int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
