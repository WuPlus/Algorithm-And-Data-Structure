/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

import java.util.LinkedList;

/**
 *
 * @author Wu
 */
public class Solution225 {

    // Push element x onto stack.

    LinkedList<Integer> queue = new LinkedList();
    int top = 0;

    public void push(int x) {
        top = x;
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        LinkedList<Integer> tmpQueue = new LinkedList();
        while (queue.size() > 1) {
            top = queue.peek();
            tmpQueue.add(queue.poll());
        }
        queue = tmpQueue;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
}
