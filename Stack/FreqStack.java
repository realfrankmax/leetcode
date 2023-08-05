package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 895. Maximum Frequency Stack
 */
public class FreqStack {
    public static void main(String[] args) {}

    Map<Integer, Integer> count;
    Map<Integer, Deque<Integer>> freq;
    int max;
    public FreqStack() {
        this.count = new HashMap<>();
        this.freq = new HashMap<>();
        this.max = 0;
    }
    
    public void push(int val) {
        count.put(val, count.getOrDefault(val, 0)+1);
        int curr = count.get(val);
        this.max = Math.max(this.max, curr);
        this.freq.computeIfAbsent(curr, x -> new ArrayDeque<>());
        this.freq.get(curr).addLast(val);
    }
    
    public int pop() {
        int res = this.freq.get(this.max).removeLast();
        if (this.freq.get(this.max).isEmpty()) {
            this.max--;
        }
        count.put(res, count.get(res)-1);
        return res;
    }
}
