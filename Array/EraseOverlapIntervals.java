package Array;

import java.util.Arrays;

/**
 * @leetcode: Non-overlapping Intervals
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {}

    // Idea is to sort by end time, and when overlapping, remove later one
    // Because the former one will make more space
    public int eraseOverlapIntervals(int[][] intervals) {
        // greedy solution to always keep the item with earlier end time
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        int count = 0;
        int endTime = Integer.MIN_VALUE;
        for (int[] i : intervals) {
            if (i[0] >= endTime) { // No overlap
                endTime = i[1];
            } else {
                count++;
            }
        }
        return count;
    }
}