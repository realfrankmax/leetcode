package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 417. Pacific Atlantic Water Flow
 */
public class PacificAtlantic {
    public static void main(String[] args) {}

    // Instead of checking from each cell, it is simple to check from the edges
    // And maintains a two dimentional array on if the cell could be flooded by the ocean.
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int min = Integer.MIN_VALUE;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            check(heights, pacific, min, i, 0);
            check(heights, atlantic, min, i, col-1);
        }
        for (int i = 0; i < col; i++) {
            check(heights, pacific, min, 0, i);
            check(heights, atlantic, min, row-1, i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }
    private void check(int[][] heights, boolean[][] ocean, int h, int r, int c) {
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || heights[r][c] < h || ocean[r][c]) {
            return ;
        }
        ocean[r][c] = true;
        check(heights, ocean, heights[r][c], r-1, c); 
        check(heights, ocean, heights[r][c], r+1, c); 
        check(heights, ocean, heights[r][c], r, c-1); 
        check(heights, ocean, heights[r][c], r, c+1); 
    }
}