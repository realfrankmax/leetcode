package Recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * @leetcode: 694. Number of Distinct Islands
 */
public class NumDistinctIslands {
    public static void main(String[] args) {}

    int[][] grid;
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands.add(trace(i, j, 0, new StringBuilder()));
                }
            }
        }
        return islands.size();
    }
    private String trace (int row, int col, int dir, StringBuilder builder) {
        if (row < 0 || col < 0 || row >= this.grid.length || col >= this.grid[0].length || this.grid[row][col] == 0) {
            builder.append(5);
            return builder.toString();
        }
        builder.append(dir);
        this.grid[row][col] = 0;
        trace(row + 1, col, 1, builder);
        trace(row - 1, col, 2, builder);
        trace(row, col + 1, 3, builder);
        trace(row, col - 1, 4, builder);
        return builder.toString();
    }
}