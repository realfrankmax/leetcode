package Heap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: 346. Moving Average from Data Stream
 */
public class MovingAverage {
    public static void main(String[] args) {}

    private Queue<Integer> q;
    private int size;
    private int sum;
    
    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if (this.size == q.size()) {
            this.sum -= q.remove();
        }
        this.sum += val;
        q.add(val);
        return (double)(this.sum) / q.size();
    }
}
