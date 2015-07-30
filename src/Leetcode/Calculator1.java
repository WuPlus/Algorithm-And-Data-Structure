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
public class Calculator1 {

    public int calculate(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        String number = "";
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (s.charAt(i)) {
                case '+':
                    if (!number.equals("")) {
                        stack.push(number);
                    }
                    number = "";
                    stack.push("+");
                    break;
                case '-':
                    if (!number.equals("")) {
                        stack.push(number);
                    }
                    number = "";
                    stack.push("-");
                    break;
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    if (!number.equals("")) {
                        stack.push(number);
                    }
                    number = "";
                    int temp = 0;
                    int temp_number = 0;
                    String str = stack.pop();
                    while (!(str.equals("("))) {
                        if (str.equals("-")) {
                            temp -= temp_number;
                        } else if (str.equals("+")) {
                            temp += temp_number;
                        } else {
                            temp_number = Integer.parseInt(str);
                        }
                        str = stack.pop();
                    }
                    temp += temp_number;
                    stack.push(temp + "");
                    break;
                case ' ':
                    break;
                default:
                    number += c;
            }
        }
        if (!number.equals("")) {
            stack.push(number);
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

    public static void main(String[] args) {
        Calculator1 c = new Calculator1();
        System.out.println(c.calculate("1 + 1"));
    }
}
