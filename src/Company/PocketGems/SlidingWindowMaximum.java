/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.PocketGems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Wu
 */
public class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int r_length = length - k + 1;
        int[] result = new int[r_length];
        Deque<Integer> deque = new LinkedList();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peek() < nums[i]) {
                deque.poll();
            }
            deque.add(nums[i]);
        }
        for (int i = 0; i < r_length; i++) {
            result[i] = deque.peek();
            if (deque.size() == k) {
                deque.poll();
                while (!deque.isEmpty() && deque.peek() < deque.peekLast()) {
                    deque.poll();
                }
            }
            while (!deque.isEmpty() && i + k < length && deque.peek() < nums[i + k]) {
                deque.poll();
            }
            if (i + k < length) {
                deque.add(nums[i + k]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = SlidingWindowMaximum.maxSlidingWindow(input, 3);
        System.out.println(Arrays.toString(res));
    }
}
