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
public class Solution232 {

    Stack<Integer> stack = new Stack<Integer>();
    int front = 0;

    // Push element x to the back of queue.

    public void push(int x) {
        if (stack.isEmpty()) {
            front = x;
        }
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> tmpStack = new Stack();
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        if (!tmpStack.isEmpty()) {
            tmpStack.pop();
        }
        if (!tmpStack.isEmpty()) {
            front = tmpStack.peek();
        }
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }

    }

    // Get the front element.
    public int peek() {
        return front;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
