package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 1472. Design Browser History
 */
public class BrowserHistory {
    public static void main(String[] args) {}

    Deque<String> history;
    Deque<String> future;
    String curr;
    public BrowserHistory(String homepage) {
        this.history = new ArrayDeque<>();
        this.future = new ArrayDeque<>();
        this.curr = homepage;
    }
    // Time O(1)
    public void visit(String url) {
        this.future = new ArrayDeque<>();
        this.history.addLast(this.curr);
        this.curr = url;
    }
    
    // Time O(min(steps, len(history)))
    public String back(int steps) {
        while (steps != 0 && !this.history.isEmpty()) {
            steps--;
            this.future.addLast(this.curr);
            this.curr = this.history.removeLast();
        }
        return this.curr;
    }
    
    // Time O(min(steps, len(history)))
    public String forward(int steps) {
        while (steps != 0 && !this.future.isEmpty()) {
            steps--;
            this.history.addLast(this.curr);
            this.curr = this.future.removeLast();
        }
        return this.curr;
    }
}
