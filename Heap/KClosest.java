package Heap;

import java.util.PriorityQueue;

/**
 * @leetcode: 973. K Closest Points to Origin
 */
public class KClosest {
    public static void main(String[] args) {}

    // Time O(nlogk)
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> topK = new PriorityQueue<>(
            (p1, p2) -> p2[0]*p2[0]+p2[1]*p2[1]-p1[0]*p1[0]-p1[1]*p1[1]);
        for (int[] p : points) {
            topK.offer(p);
            if (topK.size() == k+1) {
                topK.poll();
            }
        }
        int[][] res = new int[k][2];
        while (topK.size() != 0) {
            int[] curr = topK.poll();
            res[k-1] = new int[]{curr[0], curr[1]};
            k--;
        }
        return res;
    }
}
