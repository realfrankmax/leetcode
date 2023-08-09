package DynamicProgramming;

import java.util.Arrays;

/**
 * @leetcode: 322. Coin Change
 */
public class CoinChange {
    public static void main(String[] args) {}

    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount+1];
        Arrays.fill(count, -1);
        count[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && count[i-coin] != -1) {
                    if (count[i] == -1) {
                        count[i] = 1 + count[i-coin];
                    } else {
                        count[i] = Math.min(count[i], 1 + count[i-coin]);
                    }
                }
            }
        }
        return count[amount];
    }
}