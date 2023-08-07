package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: 200. Number of Islands
 */
public class NumIslands {
    public static void main(String[] args) {}

    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    update(grid, i, j);
                    // mark(grid, i, j);
                }
            }
        }
        return count;
    }
    private void update(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        int[] dir = new int[]{0, 1, 0, -1, 0};
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            grid[curr[0]][curr[1]] = '0';
            for (int i = 0; i < dir.length-1; i++) {
                int nr = curr[0] + dir[i];
                int nc = curr[1] + dir[i+1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
    @SuppressWarnings(value = { "unused" })
    private void mark(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return ;
        }
        grid[r][c] = '0';
        mark(grid, r+1, c);
        mark(grid, r-1, c);
        mark(grid, r, c+1);
        mark(grid, r, c-1);
    }
}