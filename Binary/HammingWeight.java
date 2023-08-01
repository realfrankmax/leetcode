package Binary;

/**
 * @leetcode: 191. Number of 1 Bits
 */
public class HammingWeight {
    public static void main(String[] args) {}

    // you need to treat n as an unsigned value
    // Faster by skipping all ending zeros by n & (n-1)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
    // O(32) Check every bit
    // public int hammingWeight(int n) {
    //     int count = 0;
    //     while (n != 0) {
    //         count += (n&1);
    //         n = (n >>> 1);
    //     }
    //     return count;
    // }
}
