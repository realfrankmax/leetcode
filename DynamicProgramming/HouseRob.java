package DynamicProgramming;

/**
 * @leetcode: 198. House Robber
 */
public class HouseRob {
    public static void main(String[] args) {}

    public int rob(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int robCurr = nums[0];
        int robPrev = 0; // Means not rob curr
        for (int i = 1; i < nums.length; i++) {
            int temp = robCurr; // robCurr is i-1
            robCurr = nums[i] + robPrev; // Skip nums[i-1]
            robPrev = Math.max(robPrev, temp); // To keep max value from not robbing i-1
        }
        return Math.max(robCurr, robPrev);
    }
}