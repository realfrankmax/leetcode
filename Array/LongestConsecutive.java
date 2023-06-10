package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: Longest Consecutive Sequence
 */
public class LongestConsecutive {
    public static void main(String[] args) {}

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (!count.containsKey(n)) {
                // Check numbers next to the curr
                // Don't need to check others, as the value of the key is the max len already
                int leftCount = count.getOrDefault(n-1, 0);
                int rightCount = count.getOrDefault(n+1, 0);
                int sum = leftCount+rightCount+1;
                max = Math.max(sum, max);
                count.put(n, sum);
                // Only maintain two sides updated with the sum
                // Because the numbers in the middle won't be checked again.
                count.put(n-leftCount, sum);
                count.put(n+rightCount, sum);
            } // else do nothing as it is a duplicate
        }
        return max;
    }
}