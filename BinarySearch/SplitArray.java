package BinarySearch;

/**
 * @leetcode: 410. Split Array Largest Sum
 */
public class SplitArray {
    public static void main(String[] args) {}

    public int splitArray(int[] nums, int k) {
        int max = 0;
        int min = Integer.MIN_VALUE;
        for (int n : nums) {
            max += n;
            min = Math.max(min, n);
        }
        int res = 0;
        while (min <= max) {
            int mid = min + (max-min)/2;
            // To get min, test mid as ceiling value
            // From big to small
            if (isValid(nums, k, mid)) {
                res = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return res;
    }
    // To check if each k subarray sum is less than target
    private boolean isValid(int[] nums, int k, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > target) {
                k--;
                sum = nums[i];
                // If k is zero, but still some items are left,
                // target is not large enough 
                if (k == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}