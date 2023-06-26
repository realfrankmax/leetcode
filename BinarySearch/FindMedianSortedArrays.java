package BinarySearch;

/**
 * @leetcode: Median of Two Sorted Arrays
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {}

    /**
     * @Time O(log(min(m, n)))
     * @Space O(1)
     * @Method 
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1] : i is [0, m]
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1] : j is [0, n]
     * 1. len(left_part) == len(right_part)
     * 2. max(left_part) ≤ min(right_part)
     * Then i + j == (m-i) + (n-j) + 1  ===> j = (m+n+1)/2 - i 
     * (NOTE: if m+n is even, +1 no difference. if m+n is odd, +1 to make the median in the left part.
     * B[j−1] ≤ A[i] and A[i−1] ≤ B[j]
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = m;
        int half = (m + n + 1)/2;
        while (left <= right) {
            int mid1 = left + (right - left)/2;
            int mid2 = half - mid1;
            if (mid1 > left && nums1[mid1-1] > nums2[mid2]) {
                right = mid1 - 1;
            } else if (mid1 < right && nums2[mid2-1] > nums1[mid1]) {
                left = mid1 + 1;
            } else {
                int maxLeft = 0;
                if (mid1 == 0) {
                    maxLeft = nums2[mid2-1];
                } else if (mid2 == 0) {
                    maxLeft = nums1[mid1-1];
                } else {
                    maxLeft = Math.max(nums1[mid1-1], nums2[mid2-1]);
                }
                if ((m+n)%2 != 0) {
                    return maxLeft;
                }
                int minRight = 0;
                if (mid1 == m) {
                    minRight = nums2[mid2];
                } else if (mid2 == n) {
                    minRight = nums1[mid1];
                } else {
                    minRight = Math.min(nums1[mid1], nums2[mid2]);
                }
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }
}