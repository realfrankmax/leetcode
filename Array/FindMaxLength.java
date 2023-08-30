package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 525. Contiguous Array
 */
public class FindMaxLength {
    public static void main(String[] args) {}

    // O(N)
    public int findMaxLength(int[] nums) {
        // Positions of sum on binarys, 0 is -1, 1 is 1.
        // If the sum is seen before, it means the sum of middle elements is zero, thus equal number of 1 and 0.
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (!pos.containsKey(sum)) {
                pos.put(sum, i);
            } else {
                max = Math.max(max, i - pos.get(sum));

            }
        }
        return max;
    }
    /**
     *
     * // In case of additional input set whose values could cancel each other
     * // different pairs will use different position in count[]
     */
    public int findMaxLength_differentPairs(int[] nums) {
        int[] count = new int[1];
        Map<String, Integer> pos = new HashMap<>();
        int len = 0;
        pos.put(Arrays.toString(count), -1);
        for (int i = 0; i < nums.length; i++) {
            count[0] += (nums[i] == 1 ? 1 : -1);
            String curr = Arrays.toString(count);
            if (pos.containsKey(curr)) {
                len = Math.max(len, i - pos.get(curr));
            } else {
                pos.put(curr, i);
            }
        }
        return len;
    }

    // O(N^2)
    // public int findMaxLength(int[] nums) {
    //     int max = 0;
    //     for (int i = 0 ; i < nums.length; i++) {
    //         int ones = 0;
    //         int zeroes = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             if (nums[j] == 1) {
    //                 ones++;
    //             } else {
    //                 zeroes++;
    //             }
    //             if (ones == zeroes) {
    //                 max = Math.max(max, j-i+1);
    //             }
    //         }
    //     }
    //     return max;
    // }
}