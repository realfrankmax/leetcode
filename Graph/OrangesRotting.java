package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: Rotting Oranges
 */
public class OrangesRotting {
    public static void main(String[] args) {}

    public int orangesRotting(int[][] grid) {
        int target = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    target++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        while (target != 0 && !q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                int[] curr = q.remove();
                int[] dir = {0, 1, 0, -1, 0};
                for (int i = 0; i < 4; i++) {
                    int nextR = curr[0] + dir[i];
                    int nextC = curr[1] + dir[i+1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && grid[nextR][nextC] == 1) {
                        grid[nextR][nextC] = 2;
                        target--;
                        q.add(new int[]{nextR, nextC});
                    }
                }
            }
            minutes++;
        }
        return target == 0 ? minutes : -1;
    }
}