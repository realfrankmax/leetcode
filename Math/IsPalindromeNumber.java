package Math;

/**
 * @leetcode: 9. Palindrome Number
 */
public class IsPalindromeNumber {
    public static void main(String[] args) {}

    /** 
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int high = 1;
        while (x/high >= 10) {
            high *= 10;
        }
        while (x != 0) {
            if (x/high != x%10) {
                return false;
            }
            x %= high;
            x /= 10;
            high /= 100;
        }
        return true;
    }
    */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x%10 == 0)) {
            return false;
        }

        int half = 0;
        while (x > half) {
            half = 10*half + x%10;
            x = x/10;
        }
        return x == half || half/10 == x;
    }
}
