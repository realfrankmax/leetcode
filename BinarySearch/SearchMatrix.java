package BinarySearch;

/**
 * @leetcode: 74. Search a 2D Matrix
 */
public class SearchMatrix {
    public static void main(String[] args) {}

    public boolean searchMatrix(int[][] matrix, int target) {
        // search row
        int top = 0;
        int bottom = matrix.length-1;
        while (top <= bottom) {
            int mid = top + (bottom-top)/2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                bottom = mid-1;
            } else {
                top = mid+1;
            }
        }
        if (bottom == -1) {
            return false;
        }
        int left = 0;
        int right = matrix[bottom].length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (matrix[bottom][mid] == target) {
                return true;
            } else if (matrix[bottom][mid] > target) {
                right = mid-1;
            } else {
                left = mid +1;
            }
        }
        return false;
    }
}