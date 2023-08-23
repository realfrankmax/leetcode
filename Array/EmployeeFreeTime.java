package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @leetcode: 759. Employee Free Time
 */
public class EmployeeFreeTime {
    public static void main(String[] args) {}

    // O(NlogK) where N is number of intervals, K is number of employee
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> freeTimes = new ArrayList<>();
        // int[]: first int is employee index, second int is schedule index of given employee
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> schedule.get(i1[0]).get(i1[1]).start - schedule.get(i2[0]).get(i2[1]).start);
        for (int i = 0; i < schedule.size(); i++) {
            pq.offer(new int[]{i, 0});
        }
        int end = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (schedule.get(curr[0]).get(curr[1]).start > end) {
                freeTimes.add(new Interval(end, schedule.get(curr[0]).get(curr[1]).start));
            }
            end = Math.max(end, schedule.get(curr[0]).get(curr[1]).end);
            if (curr[1] + 1 < schedule.get(curr[0]).size()) {
                pq.offer(new int[] {curr[0], curr[1]+1});
            }
        }
        return freeTimes;
    }
    // O(NlogN) where N is number of intervals
    // public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    //     List<Interval> freeTimes = new ArrayList<>();
    //     List<Interval> allTimes = new ArrayList<>();
    //     for (List<Interval> s : schedule) {
    //         allTimes.addAll(s);
    //     }
    //     Collections.sort(allTimes, (t1, t2) -> t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start);
    //     int end = allTimes.get(0).end;
    //     for (int i = 1; i < allTimes.size(); i++) {
    //         if (allTimes.get(i).start > end) {
    //             freeTimes.add(new Interval(end, allTimes.get(i).start));
    //         }
    //         end = Math.max(end, allTimes.get(i).end);
    //     }
    //     return freeTimes;
    // }

    class Interval {
        public int start;
        public int end;
    
        public Interval() {}
    
        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
