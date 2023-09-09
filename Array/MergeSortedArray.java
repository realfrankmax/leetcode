package Array;

/**
 * @leetcode: 88. Merge Sorted Array
 */
public class MergeSortedArray {
    public static void main(String[] args) {}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (m < 0) {
                nums1[i--] = nums2[n--];
            } else if (n < 0) {
                break;
            } else {
                if (nums1[m] > nums2[n]) {
                    nums1[i--] = nums1[m--];
                } else {
                    nums1[i--] = nums2[n--];
                }
            }
        }
    }
}
