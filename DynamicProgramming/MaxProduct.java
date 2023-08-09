package DynamicProgramming;

/**
 * @leetcode: 152. Maximum Product Subarray
 */
public class MaxProduct {
    public static void main(String[] args) {}

    // Since it is required to be a subarray (continued), it has two options
    // 1. use the value of itself (restart and discard previous subarray)
    // 2. use the product of value*prev
    // Given the product of two negative numbers results in a positive one
    // we needs to track both local max and local min, where local means the value including curr num.
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int localMax = 1;
        int localMin = 1;
        for (int n : nums) {
            int temp = localMax;
            localMax = Math.max(n, Math.max(localMax * n, localMin * n));
            localMin = Math.min(n, Math.min(temp * n, localMin * n));
            max = Math.max(max, localMax);
        }
        return max;
    }
}