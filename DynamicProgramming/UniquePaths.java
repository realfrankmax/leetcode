package DynamicProgramming;

import java.util.Arrays;

/**
 * @leetcode: 62. Unique Paths
 */
public class UniquePaths {
    public static void main(String[] args) {}

    /**
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            count[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        return count[m-1][n-1];
    }
    */
    // Space optimization
    // count[i][j-1] is the value that is calculated in j-1 within same i => count[j-1]
    // count[i-1][j] is the value that is calculated in i-1 => count[j]
    public int uniquePaths(int m, int n) {
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[j] += count[j-1];
            }
        }
        return count[n-1];
    }
}
