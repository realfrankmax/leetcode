package Graph;

/**
 * @leetcode: Longest Increasing Path in a Matrix
 */
public class LongestIncreasingPath {
    public static void main(String[] args) {}

    private int max;
    private int[][] depth;
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.depth = new int[matrix.length][matrix[0].length];
        this.max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                helper(i,j, Integer.MIN_VALUE);
            }
        }
        return max;
    }
    private int helper(int r, int c, int curr) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || curr >= matrix[r][c]) {
            return 0;
        }
        if (depth[r][c] != 0) {
            return depth[r][c];
        }
        int local = 0;
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r+dir[i];
            int nc = c+dir[i+1];
            local = Math.max(local, helper(nr, nc, matrix[r][c]));
        }
        max = Math.max(max, 1 + local);
        depth[r][c] = 1+local;
        return 1+local;
    }
}