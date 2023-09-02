package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 54. Spiral Matrix
 */
public class SpiralOrder {
    public static void main(String[] args) {}

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (top <= bottom && left <= right) {
            // top
            for (int i = left; i <= right; i++) {
                out.add(matrix[top][i]);
            }
            top++; 
            // right
            for (int i = top; i <= bottom; i++) {
                out.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            // bottom
            for (int i = right; i >= left; i--) {
                out.add(matrix[bottom][i]);
            }
            bottom--;
            // left
            for (int i = bottom; i >= top; i--) {
                out.add(matrix[i][left]);
            }
            left++;
        }
        return out;
    }
}