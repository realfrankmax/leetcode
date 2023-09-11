package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @leetcode: 18. 4Sum
 */
public class FourSum {
    public static void main(String[] args) {}

    int[] nums;
    // Time O(N^3)
    // Space O(k)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        return kSum(0, target, 4);
    }
    private List<List<Integer>> kSum(int start, long target, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start + k > this.nums.length) {
            return res;
        }
        if (k == 2) {
            return twoSum(start, target);
        }
        for (int i = start; i < this.nums.length; i++) {
            if (i == start || this.nums[i] != this.nums[i-1]) {
                for (List<Integer> curr : kSum(i+1, target-this.nums[i], k-1)) {
                    List<Integer> subset = new ArrayList<>(curr);
                    subset.add(0, this.nums[i]);
                    res.add(subset);
                }
            }
        }
        return res;
    }
    private List<List<Integer>> twoSum(int start, long target) {
        int left = start;
        int right = this.nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            int sum = this.nums[left] + this.nums[right];
            if (sum < target || (left > start && this.nums[left] == this.nums[left-1])) {
                left++;
            } else if (sum > target || (right < this.nums.length-1 && this.nums[right] == this.nums[right+1])) {
                right--;
            } else {
                res.add(List.of(this.nums[left], this.nums[right]));
                left++;
                right--;
            }
        }
        return res;
    }
}