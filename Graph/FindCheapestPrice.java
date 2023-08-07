package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @leetcode: 787. Cheapest Flights Within K Stops
 */
public class FindCheapestPrice {
    public static void main(String[] args) {}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // BFS
        // The steps are limited by k: 
        // if k == 0, we could flight directly to dst which means ONE step
        // if k == 1, it means 3 cities
        Map<Integer, List<int[]>> routes = new HashMap<>();
        // stops could have a new class to save the route info.
        Queue<int[]> stops = new LinkedList<>();
        // Keep all the cost from src to a city
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        buildGraph(flights, routes);
        stops.add(new int[]{src, 0});
        boolean reached = false;
        while (!stops.isEmpty()) {
            int size = stops.size();
            if (k < 0) {
                break;
            }
            while (size-- != 0) {
                int[] curr = stops.remove();
                for (int[] next : routes.getOrDefault(curr[0], new ArrayList<>())) {
                    int total = curr[1] + next[1];
                    // Check within current iteration while k is valid.
                    if (next[0] == dst) {
                        reached = true;
                        cost[dst] = Math.min(cost[dst], total);
                    } else {
                        // For simplicity, only choose the city with smaller total cost.
                        if (total < cost[next[0]]) {
                            cost[next[0]] = total;
                            stops.add(new int[]{next[0], total});
                        }
                    }
                }
            }
            k--;
        }
        return reached ? cost[dst] : -1;
    }
    private void buildGraph(int[][] flights, Map<Integer, List<int[]>> routes) {
        for (int[] f : flights) {
            routes.computeIfAbsent(f[0], x -> new ArrayList<>());
            routes.get(f[0]).add(new int[]{f[1], f[2]});
        }
    }
}