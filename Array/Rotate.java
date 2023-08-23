package Array;

/**
 * @leetcode: 189. Rotate Array
 */
public class Rotate {
    public static void main(String[] args) {}

    /**
     * @Note: 
     * @Time: O(n)
     * @Space: O(1)
     */
    public void rotate_1(int[] nums, int k) {
        k = k%nums.length;
        if (k == 0) {
            return;
        }
        int count = 0;
        int start = 0;
        while (count < nums.length) {
            int curr = start;
            int currVal = nums[start];
            do {
                int next = (curr + k) % nums.length;
                int temp = nums[next];
                nums[next] = currVal;
                curr = next;
                currVal = temp;
                count++;
            } while (curr != start);
            start++;
        }
    }

    /**
     * @Note: 
     * @Time: O(n)
     * @Space: O(k)
     */
    public void rotate_2(int[] nums, int k) {
        k = k%nums.length;
        if (k == 0) {
            return;
        }
        int[] temp = new int[k];
        // Copy items to be removed
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length-k+i];
        }
        // Move remaining items to new positions
        for (int i = nums.length-k-1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        // Copy k items to the front
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}