package Company.Alarm;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wu
 */
public class KElementMinGap {

    public int kElementMinGap(int[] input, int k) {
        Arrays.sort(input);
        int l = input.length;
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < l; i++) {
            minGap = Math.min(minGap, input[i + k - 1] - input[i]);
        }
        return minGap;
    }
    
    public static void main(String[] args) {
        KElementMinGap kemg = new KElementMinGap();
        int [] input = {1,2,3,9,9,6,7,8,9};
        int r = kemg.kElementMinGap(input, 3);
        System.out.println(r);
    }
}
