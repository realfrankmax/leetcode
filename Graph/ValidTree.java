package Graph;

import java.util.Arrays;

/**
 * @leetcode: Graph Valid Tree
 */
public class ValidTree {
    public static void main(String[] args) {}

    public boolean validTree(int n, int[][] edges) {
        // A tree with n nodes must have exact n-1 edges
        if (edges.length != n-1) {
            return false;
        }
        int[] link = new int[n];
        Arrays.fill(link, -1);
        for (int[] e : edges) {
            int first = find(link, e[0]);
            int second = find(link, e[1]);
            // Cycle is found
            if (first == second) {
                return false;
            }
            link[first] = second;
        }
        return true;
    }
    private int find(int[] link, int n) {
        if (link[n] == -1) {
            return n;
        }
        return find(link, link[n]);
    }
}