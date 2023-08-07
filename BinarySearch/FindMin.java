package BinarySearch;

/**
 * @leetcode: 153. Find Minimum in Rotated Sorted Array
 */
public class FindMin {
    public static void main(String[] args) {}

    // Compare mid with right
    // If n[mid] < n[right], the min is [left, mid]
    // If n[mid] > n[right], the min is [mid+1, right]
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }
}