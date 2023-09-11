package Matrix;

/**
 * @leetcode: 378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestInMatrix {
    public static void main(String[] args) {}

    // Time O(N*log(max-min))
    // Space O(1)
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[m-1][n-1];

        while (min <= max) {
            int mid = (min + max)/2;
            int count = 0;
            int col = n-1;
            for (int row = 0; row < m && col >= 0; row++) {
                while (col >= 0 && matrix[row][col] > mid) {
                    col--;
                }
                count += col+1;
            }
            // When count == k, there are two situations
            // 1. mid is not in the matrix but there is no element between mid and real result
            // 2. mid is the result
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}