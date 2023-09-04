package DynamicProgramming;

/**
 * @leetcode: 64. Minimum Path Sum
 */
public class MinPathSum {
    public static void main(String[] args) {}

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] sum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    sum[j] = grid[i][j];
                } else if (i == 0) {
                    sum[j] = sum[j-1] + grid[i][j];
                } else if (j == 0) {
                    sum[j] = sum[j] + grid[i][j];
                } else {
                    sum[j] = Math.min(sum[j], sum[j-1]) + grid[i][j];
                }
            }
        }
        return sum[n-1];
    }
}
