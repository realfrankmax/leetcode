package Array;

/**
 * @leetcode: 2161. Partition Array According to Given Pivot
 */
public class PivotArray {
    public static void main(String[] args) {}

    // Time O(N)
    // Space O(N)
    public int[] pivotArray(int[] nums, int pivot) {
        int smallCount = 0;
        int equalCount = 0;
        for (int n : nums) {
            if (n < pivot) {
                smallCount++;
            } else if (n == pivot) {
                equalCount++;
            }
        }
        int smallPointer = 0;
        int equalPointer = smallCount;
        int bigPointer = smallCount+equalCount;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[smallPointer++] = nums[i]; 
            } else if (nums[i] == pivot) {
                res[equalPointer++] = nums[i];
            } else {
                res[bigPointer++] = nums[i];
            }
        }
        return res;
    }

    // Time O(N^2)
    // Space O(1)
    public int[] pivotArray_constantSpace(int[] nums, int pivot) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                for (int j = i-1; j >= 0 && nums[j] >= pivot; j--) {
                    swap(nums, j, j+1);
                }
            } else if (nums[i] == pivot) {
                for (int j = i-1; j >= 0 && nums[j] > pivot; j--) {
                    swap(nums, j, j+1);
                }
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
