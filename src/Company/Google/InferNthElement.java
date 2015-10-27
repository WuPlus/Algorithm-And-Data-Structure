/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Wu
 */
public class InferNthElement {
    static int inferNthElement(int [] arr, int init, int n){
        HashMap<Integer,Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        int next = init;
        int step = 0;
        int steps = n;
        while(steps > 0){
            if(!map.containsKey(next)){
                list.add(next);
                map.put(next, step++);
                next = arr[next];
            }else{
                return list.get((n - map.get(next))%(step - map.get(next)) + map.get(next));
            }
            steps--;
        }
        return next;
    }
    
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6 ,1};
        System.out.println(inferNthElement(arr,0,100));
    }
}
