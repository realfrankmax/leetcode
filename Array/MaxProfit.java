package Array;

/**
 * @leetcode: Best Time to Buy and Sell Stock
 */
public class MaxProfit {
    public static void main(String[] args) {}

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            if (p < min) {
                min = p;
            }
            maxProfit = Math.max(maxProfit, p - min);
        }
        return maxProfit;
    }
}   