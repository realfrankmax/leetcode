package DynamicProgramming;

import java.util.List;

/**
 * @leetcode: 935. Knight Dialer
 */
public class KnightDialer {
    public static void main(String[] args) {}

    public int knightDialer(int n) {
        int[][] count = new int[n][10];
        for (int i = 0; i < 10; i++) {
            count[0][i] = 1;
        }
        List<List<Integer>> prev = List.of(List.of(4, 6), List.of(6, 8), List.of(7, 9),
        List.of(4, 8), List.of(0, 3, 9), List.of(), List.of(0, 1, 7), List.of(2, 6), List.of(1, 3), List.of(2, 4));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k : prev.get(j)) {
                    count[i][j] += count[i-1][k];
                    count[i][j] %= 1000000007;
                }
            }    
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += count[n-1][i];
            res %= 1000000007;
        }
        return res;
    }
}
