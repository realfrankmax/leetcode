package Array;

/**
 * @leetcode: 1248. Count Number of Nice Subarrays
 */
public class NumOfNiceSubarrays {
    public static void main(String[] args) {}

    public int numberOfSubarrays(int[] nums, int k) {
        // Two pointers
        int start = 0;
        // Count of subarrayy on currment k odd numbers
        int count = 0;
        // Count of odd numbers
        int odd = 0;
        // Total result
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 == 1) {
                odd++;
                if (odd == k) {
                    // Initial subarray count
                    count = 1;
                    // Check start pointer
                    // One even number from beginning will increment count by 1
                    while (nums[start]%2 == 0) {
                        count++;
                        start++;
                    }
                    // Move pointer to skip the first odd
                    start++;
                    total += count;
                    // Check end pointer
                    // One even number from last odd number will increment total by count
                    while (i+1 < nums.length && nums[i+1]%2 == 0) {
                        total += count;
                        i++;
                    }
                    odd--;
                }
            }
        }
        return total;
    }
}