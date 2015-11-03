/*
 *  给两个数组
 一个数组A [5,5,5,8,8,4,4,1,1,1,1,2,2,2,2,2]
 一个数组B [3,5,1,2,4]
 输出数组C [5,2,-1,8,1]
 A里面存的是int，B里面存的是A里面某一个int的出现的次数。要输出一个数组C表示A里面的哪个元素出现了那么多次。
 B[0] = 3，表示A里面5出现了三次，所以C[0]是5.
 B[1] = 5，表示A里面2出现了五次，所以C[1]是2.
 B[2] = 1，A里面没有元素出现了一次，所以C[2]是-1.
 */
package Company.PocketGems;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author Wu
 */
public class FrequenceToValue {
    
    /**
     * Time O(N) Space O(2N)
     * @param input
     * @param feq
     * @return 
     */
    static int[] frequenceToValue(int[] input, int[] feq) {
        int feq_length = feq.length;
        int[] result = new int[feq_length];
        Map<Integer, Integer> map = new HashMap();
        for (int i : input) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Map<Integer, Integer> r_map = new HashMap();
        for (Entry<Integer, Integer> e : map.entrySet()) {
            r_map.put(e.getValue(), e.getKey());
        }
        
        for (int i = 0; i < feq_length; i++) {
            if (r_map.containsKey(feq[i])) {
                result[i] = r_map.get(feq[i]);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
    
    /**
     * For test only
     * @param args 
     */
    public static void main(String[] args) {
        int[] input = {5, 5, 5, 8, 8, 4, 4, 1, 1, 1, 1, 2, 2, 2, 2, 2};
        int[] feq = {3, 5, 1, 2, 4};
        int[] result = FrequenceToValue.frequenceToValue(input, feq);
        System.out.println(Arrays.toString(result));
    }
}
