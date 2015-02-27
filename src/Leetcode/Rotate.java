/*
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Hint:
 * Could you do it in-place with O(1) extra space?
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class Rotate {
    
    //O(1) extra space
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int position;
        int tmp, tmp2;
        int l = k % length;
        //record the count of updated number
        int count = 0;
        for (int i = 0; i < l && count < length; i++) {
            position = i;
            tmp = nums[(position + k) % length];
            nums[(position + k) % length] = nums[position];
            position = (position + k) % length;
            count++;

            while (position != i) {
                //swap nums[(position+k)%length] and tmp
                tmp2 = nums[(position + k) % length];
                nums[(position + k) % length] = tmp;
                tmp = tmp2;
                position = (position + k) % length;
                count++;
            }
        }
    }
}
