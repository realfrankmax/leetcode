package Array;

/**
 * @leetcode: 135. Candy
 */
public class Candy {
    public static void main(String[] args) {}

    // Time O(N)
    // Space O(1)
    public int candy(int[] ratings) {
        int i = 1;
        int n = ratings.length;
        int total = n;
        while (i < n) {
            if (ratings[i] == ratings[i-1]) {
                i++;
                continue;
            }
            int peak = 0;
            while (i < n && ratings[i] > ratings[i-1]) {
                peak++;
                total += peak;
                i++;
            }
            if (i == n) {
                return total;
            }
            int valley = 0;
            while (i < n && ratings[i] < ratings[i-1]) {
                valley++;
                total += valley;
                i++;
            }
            total -= Math.min(peak, valley);
        }
        return total;
    }
}