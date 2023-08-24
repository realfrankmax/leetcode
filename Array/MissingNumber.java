package Array;

/**
 * @leetcode: 268. Missing Number
 */
public class MissingNumber {
    public static void main(String[] args) {}

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] != i) {
                int t = nums[i];
                nums[i] = nums[nums[i]];
                nums[t] = t;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
    // public int missingNumber(int[] nums) {
    //     int sum = 0;
    //     for (int n : nums) {
    //         sum += n;
    //     }
    //     return nums.length * (nums.length+1) / 2 - sum;
    // }
}
