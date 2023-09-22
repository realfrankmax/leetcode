package DynamicProgramming;

/**
 * @leetcode: 45. Jump Game II
 */
public class CanJumpII {
    public static void main(String[] args) {}

    public int jump(int[] nums) {
        int step = 0;
        int maxReach = 0;
        int lastReach = 0;
        for (int i = 0; i < nums.length && i <= maxReach; i++) {
            if (i > lastReach) {
                step++;
                lastReach = maxReach;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach < nums.length-1 ? -1 : step;
    }
}