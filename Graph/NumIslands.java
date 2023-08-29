package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode: 200. Number of Islands
 */
public class NumIslands {
    public static void main(String[] args) {}

    public int numIslands_rowprocessing(char[][] grid) {
        int n = grid[0].length;
        int[] prev = new int[n];
        int label = 1;
        Map<Integer, Integer> uf = new HashMap<>();
        for (char[] row : grid) {
            int[] curr = new int[n];
            if (row[0] == '1') {
                if (prev[0] != 0) {
                    curr[0] = prev[0];
                } else {
                    curr[0] = label;
                    uf.put(label, label);
                    label++;
                }
            }
            for (int i = 1; i < n; i++) {
                if (row[i] == '1') {
                    if (prev[i] == 0 && curr[i-1] == 0) {
                        curr[i] = label;
                        uf.put(label, label);
                        label++;
                    } else if (prev[i] == 0 || curr[i-1] == 0) {
                        curr[i] = prev[i] == 0 ? curr[i-1] : prev[i];
                    } else if (prev[i] == curr[i-1]) {
                        curr[i] = prev[i];
                    } else {
                        int first = find(uf, curr[i-1]);
                        int second = find(uf, prev[i]);
                        if (first != second) {
                            union(uf, first, second);
                        }
                        curr[i] = prev[i];
                    }
                }
            }
            prev = curr;
        }
        Set<Integer> count = new HashSet<>();
        for (int k : uf.keySet()) {
            int t = find(uf, k);
            count.add(t);
        }
        return count.size();
    }
    private int find(Map<Integer, Integer> map, int k) {
        while (map.get(k) != k) {
            k = map.get(k);
        }
        return k;
    }
    private void union(Map<Integer, Integer> map, int k1, int k2) {
        map.put(k1, k2);
    }

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