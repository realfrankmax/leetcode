package DynamicProgramming;

/**
 * @leetcode: 63. Unique Paths II
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] count = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                count[i] = 0;
            } else {
                // as long as there is 1 in matrix, all rest count is 0. 
                count[i] = i == 0 ? 1 : count[i-1];
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    count[j] = 0;
                } else {
                    count[j] = j == 0 ? count[j] : count[j] + count[j-1];
                }
            }
        }
        return count[obstacleGrid[0].length-1];
    }
    
}