package HighFrequency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @leetcode: 498. Diagonal Traverse
 */
public class FindDiagonalOrder {
    public static void main(String[] args) {}

    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        boolean shouldReverse = true;
        // Loop each item from first row
        for (int i = 0; i < mat[0].length; i++) {
            List<Integer> sub = new LinkedList<>();
            for (int m = 0, n = i; m < mat.length && n >= 0; m++, n--) {
                if (shouldReverse) {
                    sub.add(0, mat[m][n]);
                } else {
                    sub.add(mat[m][n]);
                }   
            }
            shouldReverse = !shouldReverse;
            res.addAll(sub);
        }
        // Loop each item from last col
        for (int i = 1; i < mat.length; i++) {
            List<Integer> sub = new LinkedList<>();
            for (int m = i, n = mat[0].length-1; m < mat.length && n >= 0; m++, n--) {
                if (shouldReverse) {
                    sub.add(0, mat[m][n]);
                } else {
                    sub.add(mat[m][n]);
                }
            }
            shouldReverse = !shouldReverse;
            res.addAll(sub);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}