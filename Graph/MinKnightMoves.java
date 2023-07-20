package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: Minimum Knight Moves
 */
public class MinKnightMoves {
    public static void main(String[] args) {}

    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        // Time limit exceeded
        // Set<String> visited = new HashSet<>();
        // Given the contraints: -300 <= x, y <= 300
        // Assume the knight never goes beyond the circle with radius 302
        boolean[][] visited = new boolean[605][605];
        Queue<int[]> pos = new LinkedList<>();
        int[][] dir = {{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        pos.add(new int[]{0, 0});
        // visited.add("0,0");
        visited[302][302] = true;
        int len = 0;
        while (true) {
            int size = pos.size();
            len++;
            while (size-- != 0) {
                int[] curr = pos.remove();
                for (int[] d : dir) {
                    int newR = curr[0] + d[0];
                    int newC = curr[1] + d[1];
                    if (newR == x && newC == y) {
                        return len;
                    }
                    // String s = newR + "," + newC;
                    // if (visited.add(s)) {
                    if (!visited[newR+302][newC+302]) {
                        pos.add(new int[]{newR, newC});
                        visited[newR+302][newC+302] = true;
                    }
                }
            }
        }
    }
}
