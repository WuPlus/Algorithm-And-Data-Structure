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
public class Solution155 {

    long min = 0;
    Stack<Long> stack = new Stack();

    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(0L);
        } else if (x >= min) {
            stack.push(x - min);
        } else {
            stack.push(x - min);
            min = x;
        }
    }

    public void pop() {
        long tmp = stack.pop();
        if (!stack.isEmpty()) {
            if (tmp < 0) {
                min = min - tmp;
            }
        }
    }

    public int top() {
        long tmp = stack.peek();
        if (tmp < 0) {
            return (int) min;
        } else {
            return (int) (tmp + min);
        }
    }

    public int getMin() {
        return (int) min;
    }
}
