package DynamicProgramming;

/**
 * @leetcode: 213. House Robber II
 */
public class HouseRobII {
    public static void main(String[] args) {}

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;
        return Math.max(robNonCircle(nums, start, end-1), robNonCircle(nums, start+1, end));
    }

    private int robNonCircle(int[] nums, int start, int end) {
        int robCurr = 0;
        int robPrev = 0;
        for (int i = start; i <= end; i++) {
            int t = robCurr;
            robCurr = robPrev + nums[i];
            robPrev = Math.max(robPrev, t);
        }
        return Math.max(robCurr, robPrev);
    }
}
