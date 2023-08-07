package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode: 207. Course Schedule
 */
public class CanFinish {
    public static void main(String[] args) {}

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            count[pre[0]]++;
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new HashSet<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int finished = 0;
        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0) {
                q.add(i);
                finished++;
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (map.containsKey(curr)) {
                for (int toFinish : map.get(curr)) {
                    count[toFinish]--;
                    if (count[toFinish] == 0) {
                        q.add(toFinish);
                        finished++;
                    }
                }
            }
        }
        return finished == numCourses;
    }
}
