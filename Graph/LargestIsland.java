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
 * @leetcode: 827. Making A Large Island
 */
public class LargestIsland {
    public static void main(String[] args) {}

    static int[] DIR = new int[]{0 , 1, 0 , -1, 0};
    // Time O(N^2)
    // Space O(N^2)
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int id = 2;
        Map<Integer, Integer> area = new HashMap<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = mark(grid, i, j, id);
                    max = Math.max(max, size);
                    area.put(id, size);
                    id++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    for (int[] neighbor : getNeighbors(i, j, n)) {
                        if (grid[neighbor[0]][neighbor[1]] > 1) {
                            seen.add(grid[neighbor[0]][neighbor[1]]);
                        }
                    }
                    int curr = 1;
                    for (int key : seen) {
                        curr += area.get(key);
                    }
                    max = Math.max(curr, max);
                }
            }
        }
        return max;
    }
    private List<int[]> getNeighbors(int currR, int currC, int n) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nextR = currR + DIR[i];
            int nextC = currC + DIR[i+1];
            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {
                res.add(new int[]{nextR, nextC});
            }
        }
        return res;
    }
    private int mark(int[][] grid, int r, int c, int id) {
        int n = grid.length;
        Queue<Integer> buffer = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        buffer.add(r*n+c);
        visited.add(r*n+c);
        grid[r][c] = id;
        while (!buffer.isEmpty()) {
            int pos = buffer.remove();
            int currR = pos/n;
            int currC = pos%n;
            for (int[] neighbor : getNeighbors(currR, currC, n)) {
                if (grid[neighbor[0]][neighbor[1]] == 1) {
                    grid[neighbor[0]][neighbor[1]] = id;
                    visited.add(neighbor[0]*n+neighbor[1]);
                    buffer.add(neighbor[0]*n+neighbor[1]);
                }
            }
        }
        return visited.size();
    }
    // Time O(N^4)
    // Space O(N^2)
    public int largestIsland_v2(int[][] grid) {
        int n = grid.length;
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, calculate(grid, i, j));
                    grid[i][j] = 0;
                }
            }
        }
        return max == -1 ? n*n : max;
    }
    private int calculate(int[][] grid, int r, int c) {
        int n = grid.length;
        Queue<Integer> buffer = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        buffer.add(r*n+c);
        visited.add(r*n+c);
        while (!buffer.isEmpty()) {
            int pos = buffer.remove();
            int currR = pos/n;
            int currC = pos%n;
            for (int i = 0; i < 4; i++) {
                int nextR = currR + DIR[i];
                int nextC = currC + DIR[i+1];
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && grid[nextR][nextC] == 1 && visited.add(nextR*n+nextC)) {
                    buffer.add(nextR*n+nextC);
                }
            }
        }
        return visited.size();
    }
}