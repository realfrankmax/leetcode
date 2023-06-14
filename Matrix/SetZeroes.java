package Matrix;

/**
 * @leetcode: Set Matrix Zeroes
 */
public class SetZeroes {
    public static void main(String[] args) {}

    // Space O(1)
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                firstRowZero = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    // Space: O(m+n)
    // public void setZeroes(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     boolean[] row = new boolean[m];
    //     boolean[] col = new boolean[n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == 0) {
    //                 row[i] = true;
    //                 col[j] = true;
    //             }
    //         }
    //     }
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (row[i] || col[j]) {
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }
}