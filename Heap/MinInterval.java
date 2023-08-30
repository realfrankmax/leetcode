package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @leetcode: 1851. Minimum Interval to Include Each Query
 */
public class MinInterval {
    public static void main(String[] args) {}

    // O(IlogI + QlogQ)
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> res = new HashMap<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);
        PriorityQueue<int[]> buffer = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1]-i1[0], i2[1]-i2[0]));
        int i = 0;
        for (int q : sortedQueries) {
            while (i < intervals.length && intervals[i][0] <= q) {
                buffer.offer(intervals[i]);
                i++;
            }
            while (!buffer.isEmpty() && buffer.peek()[1] < q) {
                buffer.poll();
            }
            if (buffer.isEmpty()) {
                res.put(q, -1);
            } else {
                res.put(q, buffer.peek()[1] - buffer.peek()[0] + 1);
            }
        }
        int[] min = new int[queries.length];
        for (i = 0; i < min.length; i++) {
            min[i] = res.get(queries[i]);
        }
        return min;
    }
}