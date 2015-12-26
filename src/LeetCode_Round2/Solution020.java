/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.Stack;

/**
 *
 * @author Wu
 */
public class Solution020 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (c) {
                    case ')':
                        c = '(';
                        break;
                    case '}':
                        c = '{';
                        break;
                    case ']':
                        c = '[';
                }
                if (c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
