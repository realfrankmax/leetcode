package Array;

/**
 * @leetcode: 215. Kth Largest Element in an Array
 */
public class FindKthLargest {
    public static void main(String[] args) {}

    // Though this could be solved with PriorityQueue
    // The solution is about Quick Sort
    // Quick sort T(n) = 2*T(n/2) + n ==> O(NlogN)
    // Quick sort in this solution only sorts half of the array
    // T(n) = T(n/2) + n ==> O(N)

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == k-1) {
                return nums[k-1];
            } else if (pivot > k-1) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;   
    }

    private int partition(int[] nums, int left, int right) {
        int mid = (left+right)/2;
        swap(nums, left, mid);
        int pointer = left+1;
        // Move elements larger than nums[left] to first half.
        for (int i = left+1; i <= right; i++) {
            if (nums[i] >= nums[left]) {
                swap(nums, i, pointer);
                pointer++;
            }
        }
        swap(nums, left, pointer-1);
        // Now every elements that are greater than nums[pointer-1] 
        // are in positions [left, pointer-1]
        return pointer-1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
