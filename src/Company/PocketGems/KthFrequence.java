/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.PocketGems;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author Wu
 */
public class KthFrequence {

    /**
     * get the kth most frequent integer in array
     *
     * @param input
     * @param k
     * @return
     */
    static int kthFrequence(int[] input, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : input) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue(new Comparator<Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });
        
        for(Entry<Integer, Integer> e: map.entrySet()){
            if (pq.size() < k) {
                pq.add(e);
            } else {
                if (pq.peek().getValue() < e.getValue()) {
                    pq.poll();
                    pq.add(e);
                }
            }
        }

        if (pq.size() < k) {
            return -1;
        }
        return pq.poll().getKey();
    }

    /**
     * For test only
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 2, 3, 4, 5, 6, 6, 6};
        System.out.println(KthFrequence.kthFrequence(input, 2));
    }

}
