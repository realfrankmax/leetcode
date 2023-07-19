package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @leetcode: Meeting Rooms II
 */
public class MinMeetingRooms {
    public static void main(String[] args) {}

    // Sort intervals based on start time. Then use PriorityQueue sort endTime. 
    // The idea is to reuse meeting room when possible.
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (int[] i : intervals) {
            if (!ends.isEmpty() && i[0] >= ends.peek()) {
                ends.poll();
            }
            ends.offer(i[1]);
        }
        return ends.size();
    }
}