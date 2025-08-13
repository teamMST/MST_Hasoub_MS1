package stacks;

import java.util.Stack;


import java.util.Stack;

public class MinStack {

    private Stack<Integer> myStack;
    private Stack<Integer> minStack;

    public MinStack() {
        myStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        myStack.push(val);
        
        // If minStack is empty or the new value is smaller or equal, push onto minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (myStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        
        int val = myStack.pop();
        
        // If the value to be removed is the minimum, also pop from minStack
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int getLast() {
        if (myStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return myStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(1);

        System.out.println("Last Element: " + minStack.getLast()); // Output: 1
        System.out.println("Minimum Element: " + minStack.getMin()); // Output: 1

        minStack.pop();
        System.out.println("Last Element after pop: " + minStack.getLast()); // Output: 7
        System.out.println("Minimum Element after pop: " + minStack.getMin()); // Output: 3
    }
}
