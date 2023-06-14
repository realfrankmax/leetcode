package Matrix;

/**
 * @leetcode: Sudoku Solver
 */
public class SolveSudoku {
    public static void main(String[] args) {}

    public void solveSudoku(char[][] board) {
        canBeSolved(board);
    }
    private boolean canBeSolved(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int d = 1; d <= 9; d++) {
                        char curr = (char) (d+'0');
                        if (isValid(board, i, j, curr)) {
                            board[i][j] = curr;
                            if (canBeSolved(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c || board[row][i] == c) {
                return false;
            }
        }
        int rowStart = row/3 * 3;
        int colStart = col/3 * 3;
        for (int i = rowStart; i < rowStart+3; i++) {
            for (int j = colStart; j < colStart+3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}