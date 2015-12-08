/*
 * Given an array, return the number of possible arithmetic sequence
 */
package Company.Amazon.OA2;

/**
 *
 * @author Wu
 */
public class CountArithmeticSequence {

    public int solution(int[] input) {
        int len = input.length;
        int res = 0;
        if (len < 3) {
            return res;
        }
        int count = 1;
        int diff = input[1] - input[0];
        for (int i = 2; i < len; i++) {
            while (i < len && input[i] - input[i - 1] == diff) {
                count++;
                i++;
            }
            res += count * (count - 1) / 2;
            if (res > 1000000000) {
                return -1;
            }
            count = 1;
            if (i < len) {
                diff = input[i] - input[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountArithmeticSequence cas = new CountArithmeticSequence();
        int[] input = {-1, 1, 3, 3, 3, 2, 1, 0};
        System.out.println(cas.solution(input));
    }
}
