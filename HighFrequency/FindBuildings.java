package HighFrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @leetcode: Buildings With an Ocean View
 */
public class FindBuildings {
    public static void main(String[] args) {}

    public int[] findBuildings(int[] heights) {
        if (heights.length == 0) {
            return new int[0];
        }
        List<Integer> pos = new ArrayList<>();
        // Assume height will be non-negative.
        int max = -1;
        for (int i = heights.length-1; i >= 0; i--) {
            if (heights[i] > max) {
                pos.add(i);
                max = heights[i];
            }
        }
        Collections.reverse(pos);
        return pos.stream().mapToInt(Integer::intValue).toArray();
    }
}