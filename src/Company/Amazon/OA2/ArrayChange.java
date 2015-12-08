/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon.OA2;

import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class ArrayChange {

    public int[] solution(int[] input, int days) {
        int len = input.length;
        int[] tmp = new int[len];
        if (len < 2) {
            return input;
        }
        while (days > 0) {
            tmp[0] = (input[1] == 0) ? 0 : 1;
            for (int i = 1; i < len - 1; i++) {
                tmp[i] = (input[i - 1] == input[i + 1]) ? 0 : 1;
            }
            tmp[len-1] = (input[len - 2] == 0) ? 0 : 1;
            input = tmp;
            days--;
        }
        return input;
    }
    
    public static void main(String[] args) {
        ArrayChange ac = new ArrayChange();
        int [] input = {1,0,0,0,0,1,0,0};
        int [] res = ac.solution(input, 1);
        System.out.println(Arrays.toString(res));
    }
}
