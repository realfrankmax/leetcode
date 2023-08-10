package DynamicProgramming;

/**
 * @leetcode: 55. Jump Game
 */
public class CanJump {
    public static void main(String[] args) {}

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length && i <= max; i++) {
            if (nums[i] + i > max) {
                max = nums[i]+i;
            }
            if (max >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}