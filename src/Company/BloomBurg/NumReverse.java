/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.BloomBurg;

import java.math.BigDecimal;

/**
 *
 * @author Wu
 */
public class NumReverse {

    /**
     * Implement with idea of String
     *
     * @param input
     * @return
     */
    static double numReverse(double input) {
        String temp = String.valueOf(input);
        StringBuilder sb = new StringBuilder();
        int l = temp.length();
        for (int i = l - 1; i >= 0; i--) {
            sb.append(temp.charAt(i));
        }
        return Double.parseDouble(sb.toString());
    }

    /**
     * Implement with bigDecimal
     *
     * @param input
     * @return
     */
    static double numReverse2(double input) {
        BigDecimal bnum = BigDecimal.valueOf(input);
        BigDecimal zero = new BigDecimal(0);
        BigDecimal ten = new BigDecimal(10);
        BigDecimal one = new BigDecimal(1);

        int count = 0;
        while (bnum.remainder(one).equals(zero)) {
            bnum.multiply(ten);
            count++;
        }
        BigDecimal result = new BigDecimal(0);
        while (bnum.equals(zero)) {
            result = result.multiply(ten).add(bnum.remainder(ten));
            bnum = bnum.subtract(bnum.remainder(ten)).divide(ten);
            count--;
        }
        while (count < 0) {
            result = result.divide(ten);
            count++;
        }
        return result.doubleValue();
    }

    public static void main(String[] args) {
        double r = numReverse(10.3);
        System.out.println(10.5132 * 10);
        System.out.println(r);
    }
}
