package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode: Bus Routes
 */
public class NumBusesToDestination {
    public static void main(String[] args) {}

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> buses = new HashMap<>();
        for (int b = 0; b < routes.length; b++) {
            for (int i = 0; i < routes[b].length; i++) {
                buses.computeIfAbsent(routes[b][i], x -> new ArrayList<>());
                buses.get(routes[b][i]).add(b);
            }
        }
        int busCount = 0;
        Set<Integer> busesTaken = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int size = q.size();
            busCount++;
            while (size-- != 0) {
                int curr = q.remove();
                // From curr stop, find all available buses
                List<Integer> nextBuses = buses.get(curr);
                for (int n : nextBuses) {
                    // If not taken before
                    if (busesTaken.add(n)) {
                        for (int nextStop : routes[n]) {
                            // Check within current iteration while busCount is valid.
                            if (nextStop == target) {
                                return busCount;
                            }
                            q.add(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}