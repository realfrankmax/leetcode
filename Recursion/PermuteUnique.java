package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @leetcode: 47. Permutations II
 */
public class PermuteUnique {
    public static void main(String[] args) {}

    private List<List<Integer>> res;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.res = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        build(new ArrayList<>(), new boolean[nums.length]);
        return this.res;
    }

    private void build(List<Integer> permutation, boolean[] used) {
        if (permutation.size() == used.length) {
            this.res.add(new ArrayList<>(permutation));
            return ;
        }
        for (int i = 0; i < used.length; i++) {
            if (i == 0 || this.nums[i] != this.nums[i-1] || used[i-1]) {
                if (!used[i]) {
                    used[i] = true;
                    permutation.add(this.nums[i]);
                    build(permutation, used);
                    permutation.remove(permutation.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}