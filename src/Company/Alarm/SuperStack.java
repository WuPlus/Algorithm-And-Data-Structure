/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Alarm;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Wu
 */
public class SuperStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noCommands = in.nextInt();
        
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < noCommands; ++i) {
            String command = in.nextLine();
            String [] split = command.split(" ");

            if (split[0].equals("push")) {
                int number = Integer.parseInt(split[1]);
                stack.push(number);
            } else if (split[0].equals("pop") && stack.size() > 0) {
                stack.pop();
            } else if (split[0].equals("inc")) {
                int count = Integer.parseInt(split[1]);
                int increment = Integer.parseInt(split[2]);
                count = Math.min(stack.size(), count);
                int size = stack.size();
                
                for (int j = 0; j < count; ++j) {
                    stack.set(size-j-1, stack.get(size-j-1)+increment);
                }
            }

            System.out.println(stack.peek());
        }
    }

}
