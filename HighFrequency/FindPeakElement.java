package HighFrequency;

/**
 * @leetcode: 162. Find Peak Element
 */
public class FindPeakElement {
    public static void main(String[] args) {}

    /**
     * @Time O(logn)
     * @Method Binary search to check mid and mid+1
     * 1. If n[mid] < n[mid+1], ascending path,left <= mid+1
     * 2. Else descending path, right <= mid.
     */
    public int findPeakElement_V1(int[] nums) {
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        // No need to check when left == right
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] < nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
        // return right; // both are ok
    }

    /**
     * @Time O(n)
     * @Method check if nums[i] < nums[i-1]
     */
    public int findPeakElement_V2(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }
        return nums.length-1;
    }
}