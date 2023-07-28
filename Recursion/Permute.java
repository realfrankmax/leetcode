package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 46. Permutations
 */
public class Permute {
    public static void main(String[] args) {}

    private List<List<Integer>> res;
    private int[] nums;

    // Time O(n*n!): n factorial. 
    // Space O(n)
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        build(new ArrayList<>(), new boolean[nums.length]);
        return this.res;    
    }

    private void build(List<Integer> permutation, boolean[] used) {
        if (permutation.size() == used.length) {
            this.res.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < this.nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation.add(nums[i]);
                build(permutation, used);
                permutation.remove(permutation.size()-1);
                used[i] = false;
            }
        }
    }
}
