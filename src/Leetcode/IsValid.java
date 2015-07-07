/*
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are 
 all valid but "(]" and "([)]" are not.
 */
package Leetcode;

import java.util.Stack;

/**
 *
 * @author Wu
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                if(current == '(') current = ')';
                if(current == '{') current = '}';
                if(current == '[') current = ']';
                stack.push(current);
            } else {
                System.out.println(current);
                if (stack.isEmpty() || current != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        }
        System.out.println("1");
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        IsValid iv = new IsValid();
        iv.isValid("()");
    }
}
