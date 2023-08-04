package Stack;

import java.util.Stack;

/**
 * @leetcode: 155. Min Stack
 */
public class MinStack {
    public static void main(String[] args) {}

    int min;
    Stack<Integer> buffer;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.buffer = new Stack<>();
    }
    
    public void push(int val) {
        if (val <= min) {
            // save previous min
            this.buffer.push(min);
            // update new min
            min = val;
        }
        this.buffer.push(val);
    }
    
    public void pop() {
        int curr = this.buffer.pop();
        if(this.min == curr) {
            this.min = this.buffer.pop();
        }
    }
    
    public int top() {
        return this.buffer.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}
