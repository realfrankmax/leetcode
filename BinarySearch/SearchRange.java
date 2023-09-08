package BinarySearch;

/**
 * @leetcode: 34. Find First and Last Position of Element in Sorted Array
 */
public class SearchRange {
    public static void main(String[] args) {}

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeft(nums, 0, nums.length-1, target);
        if (left < 0) {
            return new int[]{-1, -1};
        }
        int right = binarySearchRight(nums, left, nums.length-1, target);
        return new int[]{left, right};
    }
    private int binarySearchLeft(int[] nums, int left, int right, int target) {
        // int leftBoundary = left;
        int rightBoundary = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right == rightBoundary || nums[right+1] != target) {
            return -1;
        }
        return right+1;
    }
    private int binarySearchRight(int[] nums, int left, int right, int target) {
        int leftBoundary = left;
        // int rightBoundary = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == leftBoundary || nums[left-1] != target) {
            return -1;
        }
        return left-1;
    }
}