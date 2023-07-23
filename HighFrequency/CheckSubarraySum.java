package HighFrequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: Continuous Subarray Sum
 */
public class CheckSubarraySum {
    public static void main(String[] args) {}

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        // 23 % 6 = 5
        // (23 + 2 + 4) % 6 = 5
        Map<Integer, Integer> remainderPos = new HashMap<>();
        remainderPos.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (remainderPos.containsKey(remainder)) {
                if ((i - remainderPos.get(remainder)) >= 2) {
                    return true;
                }
            } else {
                remainderPos.put(remainder, i);
            }
        }
        return false;
    }
}