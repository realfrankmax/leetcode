package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: 286. Walls and Gates
 */
public class WallsAndGates {
    public static void main(String[] args) {}

        // Time O(m*n)
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<Integer> buffer = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    buffer.add(i*n+j);
                }
            }
        }
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            while (size-- != 0) {
                int curr = buffer.remove();
                int row = curr/n;
                int col = curr%n;
                int[] dir = {0, 1, 0, -1, 0};
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dir[i];
                    int nextCol = col + dir[i+1];
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && rooms[nextRow][nextCol] == Integer.MAX_VALUE) {
                        rooms[nextRow][nextCol] = rooms[row][col]+1;
                        buffer.add(nextRow*n+nextCol);
                    }
                }
            }
        }
    }
}
