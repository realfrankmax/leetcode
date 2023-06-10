package Array;
import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: Two Sum
 */
public class TwoSum {
    public static void main(String[] args) {}

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pos.containsKey(target - nums[i])) {
                return new int[]{pos.get(target-nums[i]), i};
            } else {
                pos.put(nums[i], i);
            }
        }
        return null;
    }
}