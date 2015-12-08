/*
 * Cache miss, given the max size of a LRU cache and a input array, calculate the miss times
 */
package Company.Amazon.OA2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class CacheMiss {
    public int solution(int [] input, int size){
        int count = 0;
        List<Integer> cache = new LinkedList();
        for(int i : input){
            if(cache.contains(i)){
                cache.remove(new Integer(i));
            }else{
                count++;
                if(cache.size() == size){
                    cache.remove(0);
                }
            }
            cache.add(i);
        }
        return count;
    }
}
