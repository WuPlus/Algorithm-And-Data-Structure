/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Wu
 */
public class MJ114 {

    static double[] mj114(int[] input) {
        int length = input.length;
        double[] result = new double[length];

        PriorityQueue<Integer> pq1 = new PriorityQueue(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<Integer> pq2 = new PriorityQueue();

        for (int i = 0; i < length; i++) {
            pq1.add(input[i]);
            if (pq1.size() > pq2.size()) {
                int max = pq1.poll();
                pq2.add(max);
            }
            if(pq2.size() > pq1.size()){
                int min = pq2.poll();
                pq1.add(min);
            }
            if (pq1.size() == pq2.size()) {
                result[i] = (pq1.peek() + pq2.peek()) / 2.0;
            } else {
                result[i] = pq1.peek();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        double[] result = MJ114.mj114(input);
        System.out.println(Arrays.toString(result));
    }
}
