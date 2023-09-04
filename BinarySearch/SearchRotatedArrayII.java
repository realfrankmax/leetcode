package BinarySearch;

/**
 * @leetcode: 81. Search in Rotated Sorted Array II
 */
public class SearchRotatedArrayII {
    public static void main(String[] args) {}

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                right--;
            }
        }
        return false;
    }
}
