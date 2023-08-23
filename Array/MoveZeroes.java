package Array;

/**
 * @leetcode: 283. Move Zeroes
 */
public class MoveZeroes {
    public static void main(String[] args) {}

    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[p];
                nums[p] = nums[i];
                nums[i] = t;
                p++;
            }
        }
    }
}