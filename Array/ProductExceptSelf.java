package Array;

/**
 * @leetcode: 238. Product of Array Except Self
 */
public class ProductExceptSelf {
    public static void main(String[] args) {}

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            p = p * nums[i-1];
            res[i] = p;
        }
        p = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            p = p * nums[i+1];
            res[i] = p * res[i];
        }
        return res;
    }
}