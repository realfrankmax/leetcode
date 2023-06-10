package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: Subarray Sum Equals K
 */
public class SubArraySum {
    public static void main(String[] args) {}

    // prefix_sum similar to path sum iii which is tree path sum.
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += prefixSum.getOrDefault(sum-k, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}