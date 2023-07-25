package HighFrequency;

/**
 * @leetcode: 2256. Minimum Average Difference
 */
public class MinimumAverageDifference {
    public static void main(String[] args) {}

    // Prefix Sum is used to get subarray sum.
    // Note that some test cases could cause integer overflow.
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n];
        for (int i = 0; i < n; i++) {
            sum[i] = nums[i] + (i == 0 ? 0 : sum[i-1]);
        }
        long minAverage = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < n; i++) {
            long firstPart = sum[i] / (i+1);
            long secondPart = n-i-1 == 0 ? 0 : (sum[n-1] - sum[i]) / (n-i-1);
            if (minAverage > Math.abs(firstPart - secondPart)) {
                minAverage = Math.abs(firstPart - secondPart);
                minIdx = i;
            }
        }
        return minIdx;
    }
}