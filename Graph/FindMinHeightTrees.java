package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @leetcode: Minimum Height Trees
 */
public class FindMinHeightTrees {
    public static void main(String[] args) {}

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        // The idea is BFS but from leaf to root.
        // Build a graph to find leaves.
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new HashSet<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new HashSet<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> level = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                level.add(entry.getKey());
            }
        }
        // The results only have two conditions: 1 or 2
        while (n > 2) {
            n -= level.size();
            Set<Integer> next = new HashSet<>();
            for (int leaf : level) {
                // It is just one next node from the graph because its size is one
                for (int nextNode : map.get(leaf)) {
                    map.get(nextNode).remove(leaf);
                    // When its size is one, it is a leaf now
                    if (map.get(nextNode).size() == 1) {
                        next.add(nextNode);
                    }
                }
            }
            level = next;
        }
        return new ArrayList<>(level);
    }
}
