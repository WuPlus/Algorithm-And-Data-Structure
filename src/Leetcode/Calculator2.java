/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.Stack;

/**
 *
 * @author Wu
 */
public class Calculator2 {

    public int calculate(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        String number = "";
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                    if (!number.equals("")) {
                        if (stack.peek().equals("*")) {
                            int x = Integer.parseInt(number);
                            stack.pop();
                            int y = Integer.parseInt(stack.pop());
                            stack.push(x * y + "");
                        } else if (stack.peek().equals("*")) {
                            int x = Integer.parseInt(number);
                            stack.pop();
                            int y = Integer.parseInt(stack.pop());
                            stack.push(x * y + "");
                        } else {
                            stack.push(number);
                        }
                    }
                    number = "";
                    stack.push("+");
                    break;
                case '-':
                    if (!number.equals("")) {
                        if (stack.peek().equals("*")) {
                            int x = Integer.parseInt(number);
                            stack.pop();
                            int y = Integer.parseInt(stack.pop());
                            stack.push(x * y + "");
                        } else if (stack.peek().equals("*")) {
                            int x = Integer.parseInt(number);
                            stack.pop();
                            int y = Integer.parseInt(stack.pop());
                            stack.push(x * y + "");
                        } else {
                            stack.push(number);
                        }
                    }
                    number = "";
                    stack.push("-");
                    break;
                case '*':
                    stack.push("*");
                    break;
                case '/':
                    stack.push("/");
                    break;
                case ' ':
                    break;
                default:
                    number += c;
            }
        }
        int temp = 0;
        int temp_number = 0;
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop();
            if (str.equals("-")) {
                temp -= temp_number;
            } else if (str.equals("+")) {
                temp += temp_number;
            } else {
                temp_number = Integer.parseInt(str);
            }
        }
        temp += temp_number;
        return temp;
    }
}
