package BinarySearch;

/**
 * @leetcode: 4. Median of Two Sorted Arrays
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {}
    int[] nums1;
    int[] nums2;
    /**
     * @Time O(log(min(m, n)))
     * @Space O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total%2 == 0) {
            return (binarySearch(0, m-1, 0, n-1, total/2)+binarySearch(0, m-1, 0, n-1, total/2-1)) / 2.0;
        } else {
            return (double) binarySearch(0, m-1, 0, n-1, total/2);
        }
    }
    private int binarySearch(int left1, int right1, int left2, int right2, int k) {
        if (left1 > right1) {
            return this.nums2[k-left1];
        }
        if (left2 > right2) {
            return this.nums1[k-left2];
        }
        int mid1 = (left1 + right1)/2;
        int mid2 = (left2 + right2)/2;

        if (mid1+mid2 < k) {
            // The kth item must be in the larger half of combined arrays
            if (this.nums1[mid1] > this.nums2[mid2]) {
                // The kth item must not be in the smaller half of the array
                // Smaller half of nums2 is the one.
                return binarySearch(left1, right1, mid2+1, right2, k);
            } else {
                // Smaller half of nums1 is the one.
                return binarySearch(mid1+1, right1, left2, right2, k);
            }
        } else {
            // The kth item must be in the smaller half of combined arrays
            if (this.nums1[mid1] > this.nums2[mid2]) {
                return binarySearch(left1, mid1-1, left2, right2, k);
            } else {
                return binarySearch(left1, right1, left2, mid2-1, k);
            }
        }
    }
    /**
     * Time O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m+n+1)/2;
        if ((m+n)%2 == 0) {
            return (find(nums1, nums2, mid) + find(nums1, nums2, mid+1)) / 2.0;
        } else {
            return (double) find(nums1, nums2, mid);
        }
    }
    private int find(int[] nums1, int[] nums2, int c) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(count != c) {
            count++;
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    if (count == c) {
                        return nums1[i];
                    }
                    i++;
                } else {
                    if (count == c) {
                        return nums2[j];
                    }
                    j++;
                }
            } else if (i < nums1.length) {
                if (count == c) {
                    return nums1[i];
                }
                i++;
            } else if (j < nums2.length) {
                if (count == c) {
                    return nums2[j];
                }
                j++;
            }
        }
        return -1;
    }
    */
}