package BinarySearch;

import java.util.Arrays;

/**
 * @leetcode: 1552. Magnetic Force Between Two Balls
 */
public class MaxDistance {
    public static void main(String[] args) {}

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = Integer.MAX_VALUE;
        int max = position[position.length-1] - position[0];
        for (int i = 1; i < position.length; i++) {
            min = Math.min(min, position[i]-position[i-1]);
        }
        // Binary search on all possible solutions
        int res = 0;
        while (min <= max) {
            int mid = min + (max-min)/2;
            // To get max, test a mid as floor value
            // From small to big
            if (isValid(position, m, mid)) {
                res = mid;
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        return res;
    }
    private boolean isValid(int[] position, int m, int distance) {
        int count = 1;
        int prev = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= distance) {
                count++;
                prev = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        return false;
    }
}