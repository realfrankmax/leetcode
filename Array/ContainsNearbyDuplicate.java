package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 219. Contains Duplicate II
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {}

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pos.containsKey(nums[i])) {
                if (i-pos.get(nums[i]) <= k) {
                    return true;
                }
            }
            pos.put(nums[i], i);
        }
        return false;
    }
}