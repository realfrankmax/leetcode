package Array;

/**
 * @leetcode: 240. Search a 2D Matrix II
 */
public class SearchMatrixII {
    public static void main(String[] args) {}

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length-1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
