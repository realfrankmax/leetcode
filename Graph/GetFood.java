package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: Shortest Path to Get Food
 */
public class GetFood {
    public static void main(String[] args) {}

    private char[][] grid;
    private char pos = '*';
    private char food = '#';
    private char wall = 'X';
    private char cell = 'O';

    public int getFood(char[][] grid) {
        this.grid = grid;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == pos) {
                    return findPath(i, j);
                }
            }
        }
        return -1;
    }
    private int findPath(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        int len = 0;
        int[] dir = {0, 1, 0, -1, 0};
        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            while (size-- != 0) {
                int[] curr = q.remove();
                for (int i = 0; i < 4; i++) {
                    int newR = curr[0]+dir[i];
                    int newC = curr[1]+dir[i+1];
                    if (inBound(newR, newC)) {
                        if (this.grid[newR][newC] == this.food) {
                            return len;
                        }
                        if (this.grid[newR][newC] == this.cell) {
                            q.add(new int[]{newR, newC});
                            // Set cell to wall RIGHT AFTER adding to the queue
                            // So that other cells won't add the same cell again.
                            this.grid[newR][newC] = this.wall;
                        }
                    }
                }
                // This line works, but will introduce more duplicate cells in the queue.
                // grid[curr[0]][curr[1]] = this.wall;        
            }
        }
        return -1;
    }
    private boolean inBound(int r, int c) {
        return r >= 0 && c >= 0 && r < this.grid.length && c < this.grid[0].length;
    }
}