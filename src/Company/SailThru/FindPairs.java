/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.SailThru;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class FindPairs {
    /**
     * Give int array, find pairs where difference is N
     * @param input
     * @param diff
     * @return 
     */
    static int findPairs(int[] input, int diff) {
        HashMap<Integer, Integer> map = new HashMap();
        int result = 0;
        for (int i : input) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (map.containsKey(e.getKey() + diff)) {
                result += map.get(e.getKey() + diff) * e.getValue();
            }
        }
        return result;
    }
}
