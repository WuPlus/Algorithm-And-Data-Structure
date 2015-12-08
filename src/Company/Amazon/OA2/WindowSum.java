/*
 code ：window sum
 intput： {4， 2， 73， 11， -5} window = 2
 output： {6， 75， 84， 6}；
 */
package Company.Amazon.OA2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Wu
 */
public class WindowSum {

    public List<Integer> windowSum(int[] input, int windowSize) {
        int len = input.length;
        List<Integer> res = new ArrayList();
        if (len < windowSize) {
            return res;
        }
        int sum = 0;
        int i;
        for (i = 0; i < windowSize; i++) {
            sum += input[i];
        }
        for (int j = i; j < len; j++) {
            res.add(sum);
            sum += input[j] - input[j - windowSize];
        }
        res.add(sum);
        return res;
    }

    public static void main(String[] args) {
        int[] input = {4, 2, 73, 11, -5};
        WindowSum ws = new WindowSum();
        List<Integer> res = ws.windowSum(input, 3);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
