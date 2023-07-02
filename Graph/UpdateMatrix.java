package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: 01 Matrix
 */
public class UpdateMatrix {
    public static void main(String[] args) {}
    // BFS: add Zero points to queue first. Then their first order neighbors.
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dis = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = -1;
                if (mat[i][j] == 0) {
                    dis[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] curr = q.remove();
            int[] dir = {0, 1, 0, -1, 0};
            for (int i = 0; i < dir.length-1; i++) {
                int nextR = curr[0]+dir[i];
                int nextC = curr[1]+dir[i+1];
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && dis[nextR][nextC] == -1) {
                    dis[nextR][nextC] = dis[curr[0]][curr[1]] + 1;
                    q.add(new int[]{nextR, nextC});
                }
            }
        }
        return dis;
    }
}