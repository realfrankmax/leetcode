package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 39. Combination Sum
 */
public class CombinationSum {
    public static void main(String[] args) {}

    private List<List<Integer>> combinations;
    private int[] candidates;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.combinations = new ArrayList<>();
        this.candidates = candidates;
        helper(new ArrayList<>(), 0, target);
        return this.combinations;
    }
    private void helper (List<Integer> combination, int pos, int target) {
        if (target == 0) {
            this.combinations.add(new ArrayList<>(combination));
            return ;
        }
        if (target < 0) {
            return ;
        }
        for (int i = pos; i < this.candidates.length; i++) {
            combination.add(this.candidates[i]);
            helper(combination, i, target-this.candidates[i]);
            combination.remove(combination.size()-1);
        }
    }
}
