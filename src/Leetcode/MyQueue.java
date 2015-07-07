/*
 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Notes:
 You must use only standard operations of a stack -- which means only 
 push to top, peek/pop from top, size, and is empty operations are valid.

 Depending on your language, stack may not be supported natively. You may 
 simulate a stack by using a list or deque (double-ended queue), as long as 
 you use only standard operations of a stack.

 You may assume that all operations are valid 
 (for example, no pop or peek operations will be called on an empty queue).
 */
package Leetcode;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Wu
 */
public class MyQueue {

    Stack<Integer> stack = new Stack<Integer>();
    int top;
    int size = 0;

    // Push element x to the back of queue.

    public void push(int x) {
        if (stack.size() == 0) {
            top = x;
        }
        stack.push(x);
        size++;
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> newstack = new Stack<Integer>();
        while (stack.size() != 1) {
            newstack.push(stack.pop());
        }
        stack.pop();
        if (newstack.size() != 0) {
            top = newstack.pop();
            //System.out.println("top->"+top);
            stack.push(top);
        }
        while (!newstack.isEmpty()) {
            stack.push(newstack.pop());
        }
    }

    // Get the front element.
    public int peek() {
        return top;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stack.size() == 0);
    }

    public void print() {
        Iterator i = stack.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + "-");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);
        m.print();
        m.pop();
        m.print();
        m.push(3);
        m.push(4);
        m.print();
        m.pop();
        m.print();
    }
}
