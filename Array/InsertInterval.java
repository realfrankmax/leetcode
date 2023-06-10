package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: Insert Interval
 */
public class InsertInterval {
    public static void main(String[] args) {}

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean hasAdded = false;
        for (int[] curr : intervals) {
            if (!hasAdded && hasOverlap(curr, newInterval)) {
                newInterval = merge(curr, newInterval);
            } else {
                if (!hasAdded && curr[0] > newInterval[0]) {
                    res.add(newInterval);
                    hasAdded = true;
                }
                res.add(curr);
            }
        }
        if (!hasAdded) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][2]);
    }

    private boolean hasOverlap(int[] i1, int[] i2) {
        return (i1[0] <= i2[0] && i2[0] <= i1[1]) || (i2[0] <= i1[0] && i1[0] <= i2[1]);
    }
    private int[] merge(int[] i1, int[] i2) {
        return new int[] {Math.min(i1[0], i2[0]), Math.max(i1[1], i2[1])};
    }
}