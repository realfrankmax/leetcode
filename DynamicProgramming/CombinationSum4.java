package DynamicProgramming;

/**
 * @leetcode: 377. Combination Sum IV
 */
public class CombinationSum4 {
    public static void main(String[] args) {}

    // Time O(target*n); The for loop in function is called at most "target" times because of cache
    // Space O(target)
    /**
    private Map<Integer, Integer> cache = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        int count = 0;
        for (int n : nums) {
            if (target >= n) {
                count += combinationSum4(nums, target-n);
            }
        }
        cache.put(target, count);
        return count;
    }
     */

    // Time O(target*n)
    // Space O(target)
    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target+1];
        count[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    count[i] += count[i-n];
                }
            }
        }
        return count[target];
    }
}