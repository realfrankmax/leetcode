package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 51. N-Queens
 */
public class SolveNQueens {
    public static void main(String[] args) {}

    private List<List<String>> res;
    // The idea is to assign one queue at one row per time.
    // If it is valid, then recursion.
    // Use pos[r]=c to record the position.
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        // pos[r] = c
        int[] pos = new int[n];
        helper(pos, 0);
        return res;
    }
    private void helper(int[] pos, int row) {
        if (row == pos.length) {
            res.add(createBoard(pos));
            return ;
        }
        for (int col = 0; col < pos.length; col++) {
            pos[row] = col;
            if (isValid(pos, row, col)) {
                helper(pos, row+1);
            }
        }
    }
    private boolean isValid(int[] pos, int row, int col) {
        int colLeft = col-1;
        int colRight = col+1;
        row--;
        while (row >= 0) {
            if (pos[row] == col || pos[row] == colLeft || pos[row] == colRight) {
                return false;
            }
            row--;
            colLeft--;
            colRight++;
        }
        return true;
    }
    private List<String> createBoard(int[] pos) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < pos.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pos.length; j++) {
                if (pos[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}