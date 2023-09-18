package Array;

/**
 * @leetcode: 713. Subarray Product Less Than K
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {}

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < nums.length) {
            product *= nums[right++];
            while (product >= k && left < right) {
                product /= nums[left++];
            }
            count += right-left;
        }
        return count;
    }
}
