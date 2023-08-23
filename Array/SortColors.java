package Array;

/**
 * @leetcode: 75. Sort Colors
 */
public class SortColors {
    public static void main(String[] args) {}

    public void sortColors(int[] nums) {
        int i0 = 0;
        int i2 = nums.length-1;
        for (int i = 0; i <= i2; i++) {
            if (nums[i] == 0) {
                int t = nums[i0];
                nums[i0] = 0;
                nums[i] = t;
                i0++;
            } else if (nums[i] == 2) {
                int t = nums[i2];
                nums[i2] = 2;
                nums[i] = t;
                i--;
                i2--;
            }
        }
    }
}