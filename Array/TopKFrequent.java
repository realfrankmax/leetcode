package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: 347. Top K Frequent Elements
 */
public class TopKFrequent {
    public static void main(String[] args) {}

    // Time O(N)
    // Space O(N)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0)+1);
            maxCount = Math.max(maxCount, count.get(n));
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = maxCount; i >= 0; i--) {
            res.addAll(buckets.get(i));
            if (res.size() >= k) {
                break;
            }
        }
        res = res.subList(0, k);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
