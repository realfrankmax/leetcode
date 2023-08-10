package DynamicProgramming;

/**
 * @leetcode: 221. Maximal Square
 */
public class MaximalSquare {
    public static void main(String[] args) {}

    /**
    // Time O(n^2)
    // Space O(n^2)
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] maxLen = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int diagonalUp = (i > 0 && j > 0) ? maxLen[i-1][j-1] : 0;
                    int rowUp = i > 0 ? maxLen[i-1][j] : 0;
                    int colLeft = j > 0 ? maxLen[i][j-1] : 0;
                    maxLen[i][j] = Math.min(diagonalUp, Math.min(rowUp, colLeft)) + 1;
                    max = Math.max(max, maxLen[i][j]);
                }
            }
        }
        return max * max;
    }
     */
    // Time O(n^2)
    // Space O(n)
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] maxLen = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int temp = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    maxLen[j] = 0;
                } else {
                    int diagonalUp = temp;
                    int rowUp = maxLen[j];
                    int colLeft = j > 0 ? maxLen[j-1] : 0;
                    maxLen[j] = Math.min(rowUp, Math.min(diagonalUp, colLeft)) + 1;
                    max = Math.max(max, maxLen[j]);
                    temp = rowUp;
                }
            }
        }
        return max * max;
    }
}