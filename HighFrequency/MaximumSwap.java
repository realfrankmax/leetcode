package HighFrequency;

/**
 * @leetcode: 670. Maximum Swap
 */
public class MaximumSwap {
    public static void main(String[] args) {}

    // Loop all digits, once we find an increasing pair n[i] > n[i-1], there must be a swap.
    // Then from that point, we find max digit on right side, and find min digit on left side.
    public int maximumSwap(int num) {
        // Assume num is non-negative.
        if (num < 10) {
            return num;
        }
        char[] d = Integer.toString(num).toCharArray();
        for (int i = 1; i < d.length; i++) {
            if (d[i] > d[i-1]) {
                int max = i;
                int j = i;
                while (j < d.length) {
                    // In order to get max, use max digit with larger index.
                    // So <= is used, not <
                    if (d[max] <= d[j]) {
                        max = j;
                    }
                    j++;
                }
                int min = i-1;
                j = i-1;
                while (j >= 0) {
                    if (d[j] < d[max]) {
                        min = j;
                    }
                    j--;
                }
                char c = d[max];
                d[max] = d[min];
                d[min] = c;
                break;
            }
        }
        return Integer.parseInt(new String(d));
    }
}