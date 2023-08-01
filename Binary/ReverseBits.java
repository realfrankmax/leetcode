package Binary;

/**
 * @leetcode: 190. Reverse Bits
 */
public class ReverseBits {
    public static void main(String[] args) {}

    // you need treat n as an unsigned value
    // Time: O(1): loop from 0 to 31
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n&1);
            n >>= 1;
        }
        return res;
    }
    // public int reverseBits(int n) {
    //     // Value of reversed bit of the index. Such as 0001 => 1000
    //     int[] map = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
    //     int res = 0;
    //     int i = 0;
    //     // Need to run the logic 8 times as only 4 bits are reversed at one time.
    //     while (i < 8) {
    //         i++;
    //         res <<= 4;
    //         res |= map[n&15];
    //         n >>>= 4;
    //     }
    //     return res;
    // }
}
