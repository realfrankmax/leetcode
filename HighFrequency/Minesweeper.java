package HighFrequency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @leetcode: 529. Minesweeper
 */
public class Minesweeper {
    public static void main(String[] args) {}

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        switch (board[r][c]) {
            case 'M':
                board[r][c] = 'X';
                return board;
            case 'E':
                mark(board, r, c);
                return board;
            default:
                return board;
        }
    }

    private void mark(char[][] board, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int count = 0;
            List<int[]> next = new ArrayList<>();
            for (int[] d : dir) {
                int newR = curr[0] + d[0];
                int newC = curr[1] + d[1];
                if (newR >= 0 && newC >= 0 && newR < board.length && newC < board[0].length) {
                    if (board[newR][newC] == 'M'){
                        count++;
                    } else if (board[newR][newC] == 'E') {
                        next.add(new int[]{newR, newC});
                    }
                }
            }
            if (count == 0) {
                board[curr[0]][curr[1]] = 'B';
                // Avoid same point being added into the queue.
                next.forEach(p -> board[p[0]][p[1]] = 'B');
                q.addAll(next);
            } else {
                board[curr[0]][curr[1]] = (char) (count+'0');
            }
        }
    }
}