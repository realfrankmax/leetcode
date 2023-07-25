package HighFrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 163. Missing Ranges
 */
public class FindMissingRanges {
    public static void main(String[] args) {}

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ranges = new ArrayList<>();
        if (nums.length == 0) {
            ranges.add(List.of(lower, upper));
            return ranges;
        }
        // Lower
        if (nums[0] > lower) {
            ranges.add(List.of(lower, nums[0]-1));
        }
        // Middle
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] > 1) {
                ranges.add(List.of(nums[i-1]+1, nums[i]-1));
            }
        }
        // Upper
        if (nums[nums.length-1] < upper) {
            ranges.add(List.of(nums[nums.length-1]+1, upper));
        }
        return ranges;
    }
}
