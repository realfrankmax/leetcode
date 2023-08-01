package Binary;

/**
 * @leetcode: 338. Counting Bits
 */
public class CountBits {
    public static void main(String[] args) {}

    // O(N)
    public int[] countBits(int n) {
        if (n < 0) {
            return new int[0];
        }
        int[] counts = new int[n+1];
        for (int i = 0; i <= n; i++) {
            counts[i] = counts[i/2] + (i%2 == 0 ? 0 : 1);
        }
        return counts;
    }
    // O(NlogN)
    // public int[] countBits(int n) {
    //     if (n < 0) {
    //         return new int[0];
    //     }
    //     int[] res = new int[n+1];
    //     for (int i = 0; i <= n; i++) {
    //         res[i] = getBits(i);
    //     }
    //     return res;
    // }
    // private int getBits(int n) {
    //     int c = 0;
    //     while (n > 0) {
    //         if (n%2 != 0) {
    //             c++;
    //         }
    //         n /= 2;
    //     }
    //     return c;
    // }
}
