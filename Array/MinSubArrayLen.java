package Array;

/**
 * @leetcode: 209. Minimum Size Subarray Sum
 */
public class MinSubArrayLen {
    public static void main(String[] args) {}

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                len = Math.min(len, i-start+1);
                sum -= nums[start++];
            }
        }
        return len == Integer.MAX_VALUE ? 0: len;
    }
}