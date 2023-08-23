package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @leetcode: 217. Contains Duplicate
 */
public class ContainsDuplicate {
    public static void main(String[] args) {}

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
