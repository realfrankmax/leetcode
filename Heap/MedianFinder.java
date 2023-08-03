package Heap;

import java.util.PriorityQueue;

/**
 * @leetcode: 295. Find Median from Data Stream
 */
public class MedianFinder {
    public static void main(String[] args) {}

    /**
     * If all integer numbers from the stream are in the range [0, 100], 
     * how would you optimize your solution?
     * 
     * int[] count = new int[101];
     * Save count of each number and since we know the total number, 
     * say 50, we could loop from 0 and stop when sum of count reach 25
     * 
     * If 99% of all integer numbers from the stream are in the range [0, 100], 
     * how would you optimize your solution?
     * 
     * The numbers outside range could be treated as 0 or 100 because the median must
     * be in the range.
     */
    private PriorityQueue<Integer> firstHalf;
    private PriorityQueue<Integer> secondHalf;
    // Time O(logN)
    public MedianFinder() {
        // The first items in both queues are middle ones in the whole set
        this.firstHalf = new PriorityQueue<>((i1, i2) -> i2-i1);
        this.secondHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        this.firstHalf.offer(num);
        this.secondHalf.offer(this.firstHalf.poll());
        // Always keep first half >= second half
        if (this.firstHalf.size() < this.secondHalf.size()) {
            this.firstHalf.offer(this.secondHalf.poll());
        }
    }
    
    public double findMedian() {
        if (this.firstHalf.size() == this.secondHalf.size()) {
            return (this.firstHalf.peek() + this.secondHalf.peek()) / 2.0;
        } else {
            return this.firstHalf.peek();
        }
    }
}
