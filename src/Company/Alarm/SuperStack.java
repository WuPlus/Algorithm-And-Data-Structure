/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Alarm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author Wu
 */
public class SuperStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noCommands = in.nextInt();
        in.nextLine();
        Map<Integer, Integer> map = new HashMap();

        List<Integer> stack = new ArrayList();
        for (int i = 0; i < noCommands; ++i) {
            String command = in.nextLine();
            StringTokenizer st = new StringTokenizer(command);
            int size = stack.size();

            if (st.nextToken().charAt(0) == 'p') {
                int number = Integer.parseInt(st.nextToken());
                stack.add(0, number);

            } else if (st.nextToken().equals("pop") && size > 0) {
                if (map.containsKey(size)) {
                    if (map.containsKey(size - 1)) {
                        map.put(size - 1, map.get(size - 1) + map.get(size));
                    }else{
                        map.put(size-1, map.get(size));
                    }
                    map.remove(size);
                }

                stack.remove(0);
            } else if (st.nextToken().equals("inc")) {
                int count = Integer.parseInt(st.nextToken());
                int increment = Integer.parseInt(st.nextToken());
                count = Math.min(size, count);

                if (map.containsKey(count)) {
                    map.put(count, map.get(count) + increment);
                }else{
                    map.put(count, increment);
                }
//                for (int j = 0; j < count; ++j) {
//                    stack.set(size - j - 1, stack.get(size - j - 1) + increment);
//                }
            }

            if (stack.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                if (map.containsKey(stack.size())) {
                    System.out.println(stack.get(0) + map.get(stack.size()));
                } else {
                    System.out.println(stack.get(0));
                }
            }
        }
    }
}
