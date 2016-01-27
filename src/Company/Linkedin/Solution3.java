/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package Company.Linkedin;

/**
 *
 * @author Wu
 */
public class Solution3 {

    public int MaximumDifferenceInAnArray(int[] input) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int min = input[0];
        int length = input.length;
        int res = -1;
        for (int i = 1; i < length; i++) {
            res = Math.max(res, input[i] - min);
            min = Math.min(min, input[i]);
        }
        return res;
    }
    
    //test
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.MaximumDifferenceInAnArray(new int[]{7,2,3,10,2,4,8,1}));
    }
}
