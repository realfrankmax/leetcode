package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @leetcode: 1293. Shortest Path in a Grid with Obstacles Elimination
 */
public class ShortestPath {
    public static void main(String[] args) {}

    static int[] DIRS = {0, 1, 0, -1, 0};

    // Time O(N*k) N is total cells.
    // Space O(N) N is total cells.
    // Dijkstra on k
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        if (k >= row + col - 2) {
            return row + col - 2;
        }

        Queue<State> q = new LinkedList<>();
        Map<String, Integer> elimination = new HashMap<>();
        State start = new State(0, 0, 0, k);
        q.offer(start);
        elimination.put("0,0", k);

        while (!q.isEmpty()) {
            State curr = q.poll();
            if (curr.row == row -1 && curr.col == col - 1) {
                return curr.steps;
            }
            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + DIRS[i];
                int nextCol = curr.col + DIRS[i+1];
                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col) {
                    int nextK = curr.k - grid[nextRow][nextCol];
                    State nextState = new State(nextRow, nextCol, curr.steps+1, nextK);
                    if (nextK >= 0 && nextK > elimination.getOrDefault(nextRow+","+nextCol, Integer.MIN_VALUE)) {
                        q.offer(nextState);
                        elimination.put(nextRow+","+nextCol, nextK);
                    }
                }
            }
        }
        return -1;
    }

    static class State {
        int row;
        int col;
        int steps;
        int k;
        public State(int row, int col, int steps, int k) {
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.k = k;
        }
    }
}