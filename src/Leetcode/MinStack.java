/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wu
 */
class MinStack {
    List<Integer> stack = new ArrayList<Integer>(); 
    List<Integer> min = new ArrayList<Integer>();
    int size;
    public void push(int x) {
        stack.add(x);
        if(size != 0){
            min.add(Math.min(x,min.get(size-1)));
        }else
            min.add(x);
        size++;
    }

    public void pop() {
        stack.remove(size-1);
        min.remove(size-1);
        size--;
    }

    public int top() {
        return stack.get(size-1);
    }

    public int getMin() {
        return min.get(size-1);
    }
}
