package Recursion;

/**
 * @leetcode: 31. Next Permutation
 */
public class NextPermutation {
    public static void main(String[] args) {}

    // 1. Find first nums[i] > nums[i-1] where i-1 will be swapped.
    // 2. Find least digit that is greater than nums[i-1] from position i
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }
        if (i == 0) {
            reverse(nums, 0, nums.length-1);
            return ;
        }
        int ptr = i;
        while (ptr < nums.length && nums[ptr] > nums[i-1]) {
            ptr++;
        }
        int t = nums[i-1];
        nums[i-1] = nums[ptr-1];
        nums[ptr-1] = t;
        reverse(nums, i, nums.length-1);
        return ;
    }
    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
        return ;
    }
}
