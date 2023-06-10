package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @leetcode: 3Sum
 */
public class ThreeSum {
    public static void main(String[] args) {}

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // nums[i] will be first item
            if (i == 0 || nums[i] != nums[i-1]) {
                // nums[j] will be second item and nums[k] will third
                int j = i+1;
                int k = nums.length-1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        res.add(List.of(nums[i], nums[j], nums[k]));
                        do {
                            j++;
                        } while (j < k && nums[j] == nums[j-1]);
                        do {
                            k--;
                        } while (j < k && nums[k] == nums[k+1]);
                    } else if (sum > 0) {
                        do {
                            k--;
                        } while (j < k && nums[k] == nums[k+1]);
                    } else {
                        do {
                            j++;
                        } while (j < k && nums[j] == nums[j-1]);
                    }
                }
            }
        }
        return res;
    }
}
