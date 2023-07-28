package HashTable;

/**
 * @leetcode: 41. First Missing Positive
 */
public class FirstMissingPositive {
    public static void main(String[] args) {}

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1) {
                // As long as the nums[i] fits in the array, it will be moved to the right position.
                if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                    // swap with nums[nums[i]-1]
                    int t = nums[i];
                    nums[i] = nums[nums[i]-1];
                    nums[t-1] = t;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}