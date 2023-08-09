package DynamicProgramming;

/**
 * @leetcode: 300. Longest Increasing Subsequence
 */
public class LengthOfLIS {
    public static void main(String[] args) {}

    /**
    // Time: O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    count[i] = Math.max(count[i], 1 + count[j]);
                }
            }
            max = Math.max(max, count[i]);
        }
        return max;
    }
     */
    // Time O(nlogn)
    // Maintain an increasing array, for each new number
    // use binary search to find the insert point, if the position is greater than current length,
    // then we have a new length

    // NOTE: For each increasing subseq, the numbers from different subseqs in the SAME position 
    // will be putting into the SAME index.
    // When there is a longer one, the right pointer will be increased.
    public int lengthOfLIS(int[] nums) {
        int[] ascending = new int[nums.length];
        int right = -1;
        for (int n : nums) {
            int insertPos = binarySearch(ascending, 0, right, n);
            ascending[insertPos] = n;
            if (insertPos == right+1) {
                right++;
            }
        }
        return right+1;
    }
    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}