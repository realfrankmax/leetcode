package Graph;

import java.util.Arrays;

/**
 * @leetcode: 323. Number of Connected Components in an Undirected Graph
 */
public class CountComponents {
    public static void main(String[] args) {}

    // Union-find
    // Decrease n by 1 after connecting two nodes.
    public int countComponents(int n, int[][] edges) {
        int[] link = new int[n];
        Arrays.fill(link, -1);
        for (int[] e : edges) {
            int first = find(link, e[0]);
            int second = find(link, e[1]);
            if (first != second) {
                link[first] = second;
                n--;
            }
        }
        return n;
    }
    private int find(int[] link, int n) {
        if (link[n] == -1) {
            return n;
        }
        return find(link, link[n]);
    }
}
