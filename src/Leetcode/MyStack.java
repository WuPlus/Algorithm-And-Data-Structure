/*
 Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author Wu
 */
public class MyStack {

    Queue<Integer> current = new ArrayDeque<Integer>();
    int top = 0;
    int size = 0;

    // Push element x onto stack.

    public void push(int x) {
        top = x;
        size++;
        current.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> copy = new ArrayDeque<Integer>();
        while (current.size() > 2) {
            int r = current.remove();
            copy.add(r);
        }
        top = current.remove();
        copy.add(top);
        current = copy;
        size--;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return (size == 0);
    }
}
