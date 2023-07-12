package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @leetcode: Course Schedule II
 */
public class FindCoursesOrder {
    public static void main(String[] args) {}

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // level[1] = 2 means that to take 1, it requires 2 prerequisites
        int[] levels = new int[numCourses];
        Map<Integer, List<Integer>> unlock = new HashMap<>();
        for (int[] p : prerequisites) {
            levels[p[0]]++;
            if (!unlock.containsKey(p[1])) {
                unlock.put(p[1], new ArrayList<>());
            }
            unlock.get(p[1]).add(p[0]);
        }
        Queue<Integer> readyToTake = new LinkedList<>();
        for (int i = 0 ; i < numCourses; i++) {
            if (levels[i] == 0) {
                readyToTake.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!readyToTake.isEmpty()) {
            int curr = readyToTake.remove();
            res.add(curr);
            if (unlock.containsKey(curr)) {
                for (int next : unlock.get(curr)) {
                    levels[next]--;
                    if (levels[next] == 0) {
                        readyToTake.add(next);
                    }
                }
            }
        }
        if (res.size() != numCourses) {
            return new int[0];
        } else {
            return res.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}