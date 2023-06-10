package Array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: Sliding Window Maximum
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {}

    // O(N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        // Index of max 
        // The index is increasing, maintained as the first item is the max of current window
        // Whenever a new max is included in the window, popping the deque from last to first 
        // until the new max couldn't take over anymore.
        Deque<Integer> pos = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // If the first max is out of the window, remove it.
            if (!pos.isEmpty() && pos.getFirst() < i-k+1) {
                pos.removeFirst();
            }
            // The new item nums[i] will pass all previous items smaller
            // Once ith item is added, smaller items will no longer be max.
            while (!pos.isEmpty() && nums[pos.getLast()] < nums[i]) {
                pos.removeLast();
            }
            pos.addLast(i);
            if (i >= k-1) {
                res[i-k+1] = nums[pos.getFirst()];
            }
        }
        return res;
    }
    // O(N*K)
    // Maintain a k-sized priority queue
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2-i1);
    //     int[] res = new int[nums.length-k+1];
    //     int idx = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         pq.offer(nums[i]);
    //         if (pq.size() == k) {
    //             res[idx++] = pq.peek();
    //             // O(k): Linear time to remove an item.
    //             pq.remove(nums[i-k+1]);
    //         }
    //     }
    //     return res;
    // }
}