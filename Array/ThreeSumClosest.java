package Array;

import java.util.Arrays;

/**
 * @leetcode: 3Sum Closest
 */
public class ThreeSumClosest {
    public static void main(String[] args) {}

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int left = i+1;
                int right = nums.length-1;
                while (left < right) {
                    int localSum = nums[i] + nums[left] + nums[right];
                    if (localSum == target) {
                        return target;
                    }
                    if (Math.abs(localSum-target) < diff) {
                        sum = localSum;
                        diff = Math.abs(localSum-target);
                    }
                    if (localSum > target) {
                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right+1]);
                    } else {
                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left-1]);
                    }
                }
            }
        }
        return sum;
    }
}