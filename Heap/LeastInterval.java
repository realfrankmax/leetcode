package Heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @leetcode: 621. Task Scheduler
 */
public class LeastInterval {
    public static void main(String[] args) {}

    public int leastInterval(char[] tasks, int n) {
        // Different tasks can be processed right after.
        // Greedy: Process tasks with the most number
        PriorityQueue<Integer> tasksByCount = new PriorityQueue<>((c1, c2) -> c2 - c1);
        Map<Character, Integer> count = new HashMap<>();
        for (char c : tasks) {
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        // The task name doesn't matter
        // Each item (count) in PQ represents a single task
        tasksByCount.addAll(count.values());
        // Save the processed task to a queue with next available time.
        Queue<int[]> buffer = new LinkedList<>();
        int time = 0;
        while (!tasksByCount.isEmpty() || !buffer.isEmpty()) {
            if (!tasksByCount.isEmpty()) {
                int currCount = tasksByCount.poll();
                if (currCount > 1) {
                    // time+n means when this task could be inserted back to tasksByCount
                    // And it will be in the task pool in time+n+1
                    buffer.add(new int[]{currCount-1, time+n});
                }
            }
            if (!buffer.isEmpty() && buffer.peek()[1] == time) {
                tasksByCount.offer(buffer.peek()[0]);
                buffer.remove();
            }
            time++;
        }
        return time;
    }
}