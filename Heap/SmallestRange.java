package Heap;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @leetcode: 632. Smallest Range Covering Elements from K Lists
 */
public class SmallestRange {
    public static void main(String[] args) {}

    // O(N*logK)
    public int[] smallestRange(List<List<Integer>> nums) {
        // Use priorityqueue to get min value
        // Keep a max variable to update range if possible
        int[] pos = new int[nums.size()];
        // pos[0] => 1 means 1st number in 0th list
        PriorityQueue<Integer> lists = new PriorityQueue<>(
            (l1, l2) -> nums.get(l1).get(pos[l1]) - nums.get(l2).get(pos[l2]));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pos.length; i++) {
            lists.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        int range_min = 0;
        int range_max = Integer.MAX_VALUE;
        while (true) {
            int minIdx = lists.poll();
            int min = nums.get(minIdx).get(pos[minIdx]);
            if (range_max-range_min > max - min) {
                range_max = max;
                range_min = min;
            }
            pos[minIdx]++;
            if (pos[minIdx] == nums.get(minIdx).size()) {
                return new int[] {range_min, range_max};
            }
            lists.offer(minIdx);
            max = Math.max(max, nums.get(minIdx).get(pos[minIdx]));
        }
    }
}
