package Array;

import java.util.Arrays;

/**
 * @leetcode: 252. Meeting Rooms
 */
public class CanAttendMeetings {
    public static void main(String[] args) {}

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}
