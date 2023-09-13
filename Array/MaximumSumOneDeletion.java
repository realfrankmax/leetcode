package Array;

/**
 * @leetcode: 1186. Maximum Subarray Sum with One Deletion
 */
public class MaximumSumOneDeletion {
    public static void main(String[] args) {}

    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] maxSumAt = new int[n];
        int[] maxSumFrom = new int[n];
        int max = arr[0];
        maxSumAt[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxSumAt[i] = Math.max(arr[i], maxSumAt[i-1]+arr[i]);
            max = Math.max(max, maxSumAt[i]);
        }
        maxSumFrom[n-1] = arr[n-1];
        for (int i = n-2; i>= 0; i--) {
            maxSumFrom[i] = Math.max(arr[i], maxSumFrom[i+1]+arr[i]);
        }
        for (int i = 1; i < n-1; i++) {
            max = Math.max(max, maxSumAt[i-1]+maxSumFrom[i+1]);
        }
        return max;
    }
}
