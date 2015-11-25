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
public class SecondMax {

    static int secondMax(int[] input) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i : input) {
            if (i >= max) {
                second = max;
                max = i;
            } else if (i > second) {
                second = i;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(secondMax(input));
    }
}
