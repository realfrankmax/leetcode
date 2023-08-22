package DynamicProgramming;

/**
 * @leetcode: 198. House Robber
 */
public class HouseRob {
    public static void main(String[] args) {}

    public int rob(int[] nums) {
        int robCurr = 0; // Max with robbing curr
        int robPrev = 0; // Max without robbing curr
        for (int n : nums) {
            int t = robCurr; // robCurr is i-1
            robCurr = robPrev + n; // Skip nums[i-1]
            robPrev = Math.max(robPrev, t); // To keep max value from not robbing i-1
        }
        return Math.max(robCurr, robPrev);
    }
}