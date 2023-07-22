package HighFrequency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: Shortest Path in Binary Matrix
 */
public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {}

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1 || grid[0][0] == 1) {
            return -1;
        }
        if (grid.length == 1 && grid[0].length == 1 && grid[0][0] == 0) {
            return 1;
        }
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> cells = new LinkedList<>();
        cells.add(new int[]{0, 0});
        grid[0][0] = 1;
        int len = 1;
        while (!cells.isEmpty()) {
            int size = cells.size();
            len++;
            while (size-- != 0) {
                int[] curr = cells.remove();
                for (int[] d : dirs) {
                    int newR = curr[0] + d[0];
                    int newC = curr[1] + d[1];
                    if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length && grid[newR][newC] == 0) {
                        if (newR == grid.length-1 && newC == grid[0].length-1) {
                            return len;
                        }
                        cells.add(new int[]{newR, newC});
                        grid[newR][newC] = 1;
                    }
                }
            }
        }
        return -1;
    }
}