package Array;

/**
 * @leetcode: Squares of a Sorted Array
 */
public class SortedSquares {
    public static void main(String[] args) {}

    public int[] sortedSquares(int[] nums) {
        int i = nums.length-1;
        int left = 0; 
        int right = nums.length-1;
        int[] res = new int[nums.length];
        while (i >= 0) {
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                res[i] = nums[right] * nums[right];
                right--;
            } else {
                res[i] = nums[left] * nums[left];
                left++;
            }
            i--;
        }
        return res;
    }
}