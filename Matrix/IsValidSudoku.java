package Matrix;

/**
 * @leetcode: 36. Valid Sudoku
 */
public class IsValidSudoku {
    public static void main(String[] args) {}

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (!validate(board[i][j], row) || !validate(board[j][i], col)) {
                    return false;
                }
            }
        }
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <=6; j+=3) {
                boolean[] box = new boolean[9];
                for (int m = i; m < i+3; m++) {
                    for (int n = j; n < j+3; n++) {
                        if (!validate(board[m][n], box)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    private boolean validate(char c, boolean[] checked) {
        if (c == '.') {
            return true;
        } else if (c >= '1' && c <= '9' && !checked[c-'1']) {
            checked[c-'1'] = true;
            return true;
        } else {
            return false;
        }
    }
}