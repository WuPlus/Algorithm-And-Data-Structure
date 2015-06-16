/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int length = num.length;
        for(int i=0;i<length;i++){
            if(map.containsKey(num[i])){
                int tmp = map.get(num[i]);
                tmp++;
                map.put(num[i],tmp);
            }
            else
                map.put(num[i],1);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int tmp = iterator.next();
            if(map.get(tmp) > length/2){
                return tmp;
            }
        }
        return 0;
    }
}
