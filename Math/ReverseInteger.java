package Math;

/**
 * @leetcode: 7. Reverse Integer
 */
public class ReverseInteger {
    public static void main(String[] args) {}

    // 2147483647
    // If res > (Integer.MAX_VALUE)/10, res is must overflow
    // If res == (Integer.MAX_VALUE)/10 + n and when n > 7, res could overflow
    // but n could only be 0, 1, 2
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x%10;
            if ((x > 0 && res > Integer.MAX_VALUE/10) || (x < 0 && res < Integer.MIN_VALUE/10)) {
                return 0;
            }
            res = 10*res+digit;
            x /= 10;
        }
        return res;
    }
}
