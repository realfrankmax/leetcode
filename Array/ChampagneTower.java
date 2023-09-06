package Array;

/**
 * @leetcode: 799. Champagne Tower
 */
public class ChampagneTower {
    public static void main(String[] args) {}

    // Time O(row^2)
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] wine = new double[100][100];
        wine[0][0] = (double) poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double flow = (wine[i][j]-1)/2.0;
                if (flow > 0) {
                    wine[i+1][j] += flow;
                    wine[i+1][j+1] += flow;
                }
            }
        }
        // The poured could be really large and the queried glass is in the middle
        // While the wine[][] is greater than 1 because it means total wine flowing through.
        return Math.min(1.0, wine[query_row][query_glass]);
    }
}