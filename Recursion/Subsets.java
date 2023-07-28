package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 78. Subsets
 */
public class Subsets {
    public static void main(String[] args) {}

    // Time O(n*2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> next = new ArrayList<>(res.get(i));
                next.add(n);
                res.add(next);
            }
        }
        return res;
    }

    private List<List<Integer>> res;
    private int[] nums;
    public List<List<Integer>> subsets_2(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        build(new ArrayList<>(), 0);
        return this.res;
    }

    private void build(List<Integer> subset, int start) {
        this.res.add(new ArrayList<>(subset));
        for (int i = start; i < this.nums.length; i++) {
            subset.add(nums[i]);
            build(subset, i+1);
            subset.remove(subset.size()-1);
        }
    }
}