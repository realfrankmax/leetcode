package Matrix;

/**
 * @leetcode: 59. Spiral Matrix II
 */
public class SpiralOrderII {
    public static void main(String[] args) {}

    public int[][] generateMatrix(int n) {
        int i = 1;
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int[][] matrix = new int[n][n];
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int k = colStart; k <= colEnd; k++) {
                matrix[rowStart][k] = i++;
            }
            rowStart++;
            for (int k = rowStart; k <= rowEnd; k++) {
                matrix[k][colEnd] = i++;
            }
            colEnd--;
            for (int k = colEnd; k >= colStart; k--) {
                matrix[rowEnd][k] = i++;
            }
            rowEnd--;
            for (int k = rowEnd; k >= rowStart; k--) {
                matrix[k][colStart] = i++;
            }
            colStart++;
        }
        return matrix;
    }
}
