/*
 给一个数组，包含1到n，有的出现一次，有的出现两次，用constant space， O(n) time
 找出出现两次的数。不能排序 不能hash
 */
package Company.PocketGems;

/**
 *
 * @author Wu
 */
public class CountDuplicates {

    static int countDuplicates(int[] input) {
        int result = 0;
        for (int i : input) {
            int j = Math.abs(i);
            if (input[j - 1] < 0) {
                result++;
            } else {
                input[j - 1] *= -1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int [] inputs = {1,2,2,3,4,5,5,3,1};
        int r = CountDuplicates.countDuplicates(inputs);
        System.out.println(r);
    }
}
