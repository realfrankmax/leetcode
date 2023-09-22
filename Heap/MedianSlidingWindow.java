package Heap;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @leetcode: 480. Sliding Window Median
 */
public class MedianSlidingWindow {
    public static void main(String[] args) {}

    // TreeSet has faster remove.
    // But since it is a set, the value needs to be unique.
    // Time O(nlogk)
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> small = new TreeSet<>((i1, i2) -> nums[i1] == nums[i2] ? Integer.compare(i1, i2) : Integer.compare(nums[i2], nums[i1]));
        TreeSet<Integer> big = new TreeSet<>((i1, i2) -> nums[i1] == nums[i2] ? Integer.compare(i1, i2) : Integer.compare(nums[i1], nums[i2]));

        int n = nums.length;
        double[] res = new double[n-k+1];

        for (int i = 0; i < n; i++) {
            if (small.size() >= big.size()) {
                small.add(i);
                big.add(small.pollFirst());
            } else {
                big.add(i);
                small.add(big.pollFirst());
            }
            if (i >= k-1) {
                if (small.size() == big.size()) {
                    res[i-k+1] = ((double)nums[small.first()] + (double)nums[big.first()]) / 2.0;
                } else {
                    res[i-k+1] = (double) nums[big.first()];
                }
                if(!big.remove(i-k+1)) {
                    small.remove(i-k+1);
                }
            }
        }
        return res;
    }
    // Time O(n*k) because pq remove takes linear time
    public double[] medianSlidingWindow_pq(int[] nums, int k) {
        PriorityQueue<Integer> small = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
        PriorityQueue<Integer> big = new PriorityQueue<>();

        int n = nums.length;
        double[] res = new double[n-k+1];

        for (int i = 0; i < n; i++) {
            if (small.size() >= big.size()) {
                small.offer(nums[i]);
                big.offer(small.poll());
            } else {
                big.offer(nums[i]);
                small.offer(big.poll());
            }
            if (i >= k-1) {
                if (small.size() == big.size()) {
                    res[i-k+1] = ((double)small.peek() + (double)big.peek()) / 2.0;
                } else {
                    res[i-k+1] = (double) big.peek();
                }
                if(!big.remove(nums[i-k+1])) {
                    small.remove(nums[i-k+1]);
                }
            }
        }
        return res;
    }
}
