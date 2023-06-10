package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: Contiguous Array
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