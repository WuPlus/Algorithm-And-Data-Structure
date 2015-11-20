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
public class NumReverse {

    static double numReverse(double input) {
        String temp = String.valueOf(input);
        StringBuilder sb = new StringBuilder();
        int l = temp.length();
        for (int i = l - 1; i >= 0; i--) {
            sb.append(temp.charAt(i));
        }
        return Double.parseDouble(sb.toString());
    }

    static double numReverse2(double input) {
        double result = 0;
        int tmp = (int) input;
        while (tmp > 0) {
            result += result * 10 + tmp % 10;
            tmp = tmp/10;
        }
        return result;
    }

    public static void main(String[] args) {
        double r = numReverse(10.3);
        System.out.println(10.5132*10);
        System.out.println(r);
    }
}
