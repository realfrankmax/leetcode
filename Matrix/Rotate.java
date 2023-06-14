package Matrix;

/**
 * @leetcode: Rotate Image
 */
public class Rotate {
    public static void main(String[] args) {}

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i-1; j++) {
                int t = matrix[i][j];
                // clockwise
                // Find pattern from first copy
                // Outside indexes are same, inside ones are different.
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = t;
                // counter-clockwise
                // matrix[i][j] = matrix[j][n-i-1];
                // matrix[j][n-i-1] = matrix[n-i-1][n-j-1];
                // matrix[n-i-1][n-j-1] = matrix[n-j-1][i];
                // matrix[n-j-1][i] = t;
            }
        }
    }
}