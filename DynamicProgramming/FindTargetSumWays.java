package DynamicProgramming;

import java.util.Arrays;

/**
 * @leetcode: 494. Target Sum
 */
public class FindTargetSumWays {
    public static void main(String[] args) {}

    // Similar ways as 416 Partition Equal Subset Sum
    /** 
     * P: positive; N: negative 
     * sum(P) - sum(N) = T;
     * 2*sum(P) = T + sum(ALL);
     * sum(P) = (T + sum(ALL))/2;
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum+target >= 0 && (sum+target)%2 == 0) {
            return findCombinationSum(nums, (sum+target)/2);
        }
        return 0;
    }
    private int findCombinationSum(int[] nums, int target) {
        int[][] count = new int[nums.length+1][target+1];
        for (int i = 0; i <= nums.length; i++) {
            count[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) { 
                count[i][j] = count[i-1][j];
                if (j >= nums[i-1]) {
                    count[i][j] += count[i-1][j-nums[i-1]];
                }
            }
        }
        return count[nums.length][target];
    }

    // Time O(2^n)
    /** 
    private int count;
    public int findTargetSumWays(int[] nums, int target) {
        this.count = 0;
        helper(nums, 0, target, 0);
        return this.count;
    }
    private void helper(int[] nums, int pos, int target, int sum) {
        if (sum == target && pos == nums.length) {
            this.count++;
            return ;
        }
        if (pos < nums.length) {
            helper(nums, pos+1, target, sum + nums[pos]);
            helper(nums, pos+1, target, sum - nums[pos]);
        }
    }
    */
}