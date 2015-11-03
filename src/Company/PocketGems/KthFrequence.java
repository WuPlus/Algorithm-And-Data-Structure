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
     * @param input
     * @param k
     * @return 
     */
    static int kthFrequence(int [] input, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:input){
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i)+1);
            }
        }
        
        Set<Entry<Integer,Integer>> set = map.entrySet();
        Iterator<Entry<Integer,Integer>> i = set.iterator();
        PriorityQueue<Entry<Integer,Integer>> pq = new PriorityQueue(new Comparator<Entry<Integer,Integer>>(){

            @Override
            public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
       
        });
        
        while(i.hasNext()){
            Entry<Integer,Integer> e = i.next();
            if(pq.size() < k){
                pq.add(e);
            }else{
                if(pq.peek().getValue() < e.getValue()){
                    pq.poll();
                    pq.add(e);
                }
            }
        }
        
        
        if(pq.size() < k) return -1;
        return pq.poll().getKey();
    }
    
    
}
