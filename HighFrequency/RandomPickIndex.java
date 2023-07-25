package HighFrequency;

import java.util.Random;

/**
 * @leetcode: 398. Random Pick Index
 */
public class RandomPickIndex {
    public static void main(String[] args) {}

    // Assume the number of target is unknow, reservoir sampling is used.
    // Assume target has 3 occurrences.
    // The probability of last item being picked is 1/3
    // The probalility of the second item being picked is (1/2) * (2/3) => 1/3
    private int[] nums;
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        Random rand = new Random();
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (rand.nextInt(++count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
    /** 
    private Map<Integer, List<Integer>> pos;
    public RandomPickIndex(int[] nums) {
        this.pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            pos.computeIfAbsent(nums[i], x -> new ArrayList<>());
            pos.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        if (!this.pos.containsKey(target)) {
            return -1;
        }
        List<Integer> positions = this.pos.get(target);
        Random rand = new Random();
        return positions.get(rand.nextInt(positions.size()));
    }
    */
}