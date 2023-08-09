package DynamicProgramming;

/**
 * @leetcode: 416. Partition Equal Subset Sum
 */
public class CanPartition {
    public static void main(String[] args) {}

    // For each num, the subarray could include it or not.
    // So the outer loop is to check nums and inner loop is to check range [1, sum/2]
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum %2 != 0) {
            return false;
        }
        boolean[][] state = new boolean[nums.length+1][sum/2+1];
        // state[i][j] means if we can get sum j from first i items.
        // if we don't pick it, state[i][j] = state[i-1][j]
        // If we pick nums[i]. state[i][j] = state[i-1][j-nums[i]]
        for (int i = 0; i <= nums.length; i++) {
            state[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum/2; j++) {
                state[i][j] = state[i-1][j];
                if (j >= nums[i-1]) {
                    state[i][j] = state[i][j] || state[i-1][j - nums[i-1]];
                }
            }
        }
        return state[nums.length][sum/2];
    }
}