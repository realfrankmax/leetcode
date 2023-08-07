package Graph;

/**
 * @leetcode: 79. Word Search
 */
public class WordSearch {
    public static void main(String[] args) {}

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(char[][] board, int r, int c, String word, int pos, boolean[][] visited) {
        if (pos == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || board[r][c] != word.charAt(pos)) {
            return false;
        }
        visited[r][c] = true;
        int[] dir = {0, 1, 0, -1, 0};
        for (int i = 0; i < dir.length-1; i++) {
            int nr = r+dir[i];
            int nc = c+dir[i+1];
            if (check(board, nr, nc, word, pos+1, visited)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}