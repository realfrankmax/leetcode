package Array;

/**
 * @leetcode: 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicates {
    public static void main(String[] args) {}

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[k+1] = nums[i];
                k++;
            }
        }
        return k+1;
    }
}