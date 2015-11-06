/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.PocketGems;

import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class StringCompression {

    static String compress(char[] input) {
        int end = 0;
        int length = input.length;
        int count = 1;
        for (int i = 0; i < length - 1; i++) {
            if (input[i] == input[i + 1]) {
                count++;
            } else {
                if (count > 1) {
                    String count_string = String.valueOf(count);
                    for (int j = 0; j < count_string.length(); j++) {
                        input[end++] = count_string.charAt(j);
                    }
                    input[end++] = input[i];
                } else {
                    input[end++] = input[i];
                }
                count = 1;
            }
        }
        if (count == 1) {
            input[end++] = input[length - 1];
        } else {
            input[end++] = (char) (count + '0');
            input[end++] = input[length - 1];
        }
        return new String(Arrays.copyOfRange(input, 0, end));
    }

    public static void main(String[] args) {
        char[] ary = {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B','B', 'B', 'B', 'B','c', 'c', 'c', 'D', 'D', 'D'};
        System.out.println(compress(ary));
    }
}
