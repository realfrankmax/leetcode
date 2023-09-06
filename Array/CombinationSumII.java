package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @leetcode: 40. Combination Sum II
 */
public class CombinationSumII {
    public static void main(String[] args) {}

    int[] candidates;
    List<List<Integer>> res;
    // Time O(2^n)
    // Space O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.res = new ArrayList<>();
        helper(0, target, new ArrayList<>());
        return this.res;
    }
    private void helper(int pos, int target, List<Integer> list) {
        if (target == 0) {
            this.res.add(new ArrayList<>(list));
            return ;
        }
        if (target < 0) {
            return ;
        }
        for (int i = pos; i < this.candidates.length; i++) {
            if (i == pos || this.candidates[i-1] != this.candidates[i]) {
                list.add(this.candidates[i]);
                helper(i+1, target - this.candidates[i], list);
                list.remove(list.size()-1);
            }
        }
    }
}