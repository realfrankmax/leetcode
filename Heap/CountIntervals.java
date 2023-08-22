package Heap;

import java.util.TreeSet;

/**
 * @leetcode: 2276. Count Integers in Intervals
 */
public class CountIntervals {
    public static void main(String[] args) {}

    TreeSet<Interval> intervals;
    int count;
    public CountIntervals() {
        intervals = new TreeSet<>((i1, i2) -> i1.left == i2.left ? i1.right - i2.right : i1.left - i2.left);
        count = 0;
    }
    // Time O(logn)
    public void add(int left, int right) {
        Interval newInterval = new Interval(left, right);
        // Try to find interval on the left side
        Interval start = this.intervals.floor(newInterval);
        if (start == null || start.right < left) {
            // Interval on the right side
            start = this.intervals.ceiling(newInterval);
        }
        while (start != null && hasOverlap(start, newInterval)) {
            newInterval = merge(start, newInterval);
            this.count -= start.right-start.left+1;
            this.intervals.remove(start);
            start = this.intervals.ceiling(newInterval);
        }
        this.count += newInterval.right-newInterval.left+1;
        this.intervals.add(newInterval);
    }
    
    public int count() {
        return this.count;
    }

    private boolean hasOverlap(Interval i1, Interval i2) {
        return (i1.left <= i2.left && i2.left <= i1.right) 
            || (i2.left <= i1.left && i1.left <= i2.right);
    }

    private Interval merge(Interval i1, Interval i2) {
        return new Interval(Math.min(i1.left, i2.left), Math.max(i1.right, i2.right));
    }

    class Interval {
        int left;
        int right;
        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
