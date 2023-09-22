package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: 785. Is Graph Bipartite?
 */
public class IsBipartite {
    public static void main(String[] args) {}

    // As long as two nodes are connected, they must be in different groups
    // Time O(m*n)
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] node = new int[n];
        Arrays.fill(node, -1);
        for (int i = 0; i < n; i++) {
            if (node[i] == -1) {
                node[i] = 0;
                Queue<Integer> buffer = new LinkedList<>();
                buffer.add(i);
                while (!buffer.isEmpty()) {
                    int size = buffer.size();
                    while (size-- != 0) {
                        int curr = buffer.remove();
                        for (int neighbor : graph[curr]) {
                            if (node[neighbor] == -1) {
                                node[neighbor] = node[curr] ^ 1;
                                buffer.add(neighbor);
                            } else if (node[neighbor] == node[curr]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}