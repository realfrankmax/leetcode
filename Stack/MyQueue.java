package Stack;

import java.util.Stack;

/**
 * @leetcode: 232. Implement Queue using Stacks
 */
public class MyQueue {
    public static void main(String[] args) {}

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();    
    }
    
    public void push(int x) {
        this.s1.push(x);
    }
    
    public int pop() {
        if (!this.s2.isEmpty()) {
            return this.s2.pop();
        }
        while (!this.s1.isEmpty()) {
            this.s2.push(this.s1.pop());
        }
        return this.s2.pop();
    }
    
    public int peek() {
        if (!this.s2.isEmpty()) {
            return this.s2.peek();
        }
        while (!this.s1.isEmpty()) {
            this.s2.push(this.s1.pop());
        }
        return this.s2.peek();
    }
    
    public boolean empty() {
        return this.s1.isEmpty() && this.s2.isEmpty();
    }
}
