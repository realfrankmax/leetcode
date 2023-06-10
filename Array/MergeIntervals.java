package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @leetcode: Merge Intervals
 */
public class MergeIntervals {
    public static void main(String[] args) {}

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1]-i2[1] : i1[0] - i2[0]);
        for (int[] i : intervals) {
            if (res.isEmpty()) {
                res.add(new int[]{i[0], i[1]});
            } else {
                int[] prev = res.get(res.size()-1);
                if (hasOverlap(prev, i)) {
                    i = merge(prev, i);
                    res.remove(res.size()-1);
                }
                res.add(new int[] {i[0], i[1]});
            }
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