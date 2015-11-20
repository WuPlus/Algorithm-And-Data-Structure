/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Guidewire;

import java.util.*;

/**
 *
 * @author Wu
 */
public class Scramble3 {

    Map<String, Integer> map = new HashMap();

    public static void main(String[] args) {
        Scramble3 s3 = new Scramble3();
        //s3.scrableCount(10, 99);
        s3.scrableCount(1000, 9999);
        s3.scrableCount(10000000, 20000000);
    }

    long scrableCount(int start, int end) {
        for (int i = start; i <= end; i++) {
            addCount(String.valueOf(i));
        }
        long result = 0;

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            int count = e.getValue();
            result += ((count - 1) * count) / 2;
        }
        System.out.println(result);
        return result;
    }

    private void addCount(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        String tmp = Arrays.toString(temp);
        if (map.containsKey(tmp)) {
            map.put(tmp, map.get(tmp) + 1);
        } else {
            map.put(tmp, 1);
        }
    }
}
