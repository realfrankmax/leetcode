package BinarySearch;

/**
 * @leetcode: 74. Search a 2D Matrix
 */
public class SearchMatrix {
    public static void main(String[] args) {}

    public boolean searchMatrix(int[][] matrix, int target) {
        // Binary search on column 0
        int top = 0;
        int bottom = matrix.length-1;
        while (top <= bottom) {
            int mid = top + (bottom-top)/2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                bottom--;
            } else {
                top++;
            }
        }
        if (bottom == -1) {
            return false;
        }
        // bottom is THE row that could contain target
        // Binary search on row Bottom
        int left = 0;
        int right = matrix[0].length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (matrix[bottom][mid] == target) {
                return true;
            } else if (matrix[bottom][mid] > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}