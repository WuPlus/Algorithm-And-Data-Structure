/*
 * Given four integers, make F(S) = abs(S[0]-S[1]) + abs(S[1]-S[2]) + abs(S[2]-S[3]) to be largest
 */
package Company.Amazon.OA2;

import java.util.Arrays;

/**
 *
 * @author Wu
 */
public class FourInteger {

    public int largestS(int[] input) {
        Arrays.sort(input);
        return input[2] - input[0] + input[3] - input[0] + input[3] - input[1];
    }

    public int[] largestS(int A, int B, int C, int D) {
        int[] res = {A, B, C, D};
        Arrays.sort(res);
        swap(res, 0, 1);
        swap(res, 2, 3);
        swap(res, 0, 3);
        return res;
    }

    public void swap(int[] input, int i, int j) {
        input[i] = input[i] + input[j];
        input[j] = input[i] - input[j];
        input[i] = input[i] - input[j];
    }
    
    
    public static void main(String[] args) {
        FourInteger fi = new FourInteger();
        System.out.println(Arrays.toString(fi.largestS(2, 4, 6, 8)));
    }

}
