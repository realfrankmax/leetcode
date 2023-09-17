package Array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 862. Shortest Subarray with Sum at Least K
 */
public class MinSubArrayLenII {
    public static void main(String[] args) {}

    // Time O(N)
    // Similar to 209. Minimum Size Subarray Sum
    // This problem has negative value in the array
    public int shortestSubarray(int[] nums, int k) {
        int len = Integer.MAX_VALUE;
        Deque<Integer> pos = new ArrayDeque<>();
        long[] presum = new long[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i-1] + nums[i-1];
        }
        pos.addLast(0);
        for (int i = 1; i <= nums.length; i++) {
            while (!pos.isEmpty() && presum[i] - presum[pos.getFirst()] >= k) {
                len = Math.min(len, i-pos.removeFirst());
            }
            while (!pos.isEmpty() && presum[i] <= presum[pos.getLast()]) {
                pos.removeLast();
            }
            pos.addLast(i);
        }
        return len == Integer.MAX_VALUE ? -1: len;
    }
}