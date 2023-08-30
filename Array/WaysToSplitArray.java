package Array;

/**
 * @leetcode: 2270. Number of Ways to Split Array
 */
public class WaysToSplitArray {
    public static void main(String[] args) {}

    public int waysToSplitArray(int[] nums) {
        int count = 0;
        long sum = 0;
        long leftSum = 0;
        long rightSum = 0;
        for (int n : nums){
            sum += n;
        }

        for (int i = 0; i < nums.length-1; i++){
            leftSum += nums[i];
            rightSum = sum-leftSum;
            if (leftSum >= rightSum){
                count++;
            }
        }
        return count;
    }
}
