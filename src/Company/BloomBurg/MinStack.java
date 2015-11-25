/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.BloomBurg;

import java.util.Stack;

/**
 *
 * @author Wu
 */
public class MinStack {

    int min;
    Stack<Integer> stack = new Stack<Integer>();

    void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(0);
        } else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    void pop(int x) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (top < 0) {
            min = min - top;
        }
    }

    int top() {
        int top = stack.peek();
        if (top > 0) {
            return top + min;
        } else {
            return min;
        }
    }

    int getMin() {
        return min;
    }
}
