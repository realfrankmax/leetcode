package Array;

/**
 * @leetcode: Valid Palindrome
 */
public class IsPalindrome {
    public static void main(String[] args) {}

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
            } else if (!isAlphaNumeric(s.charAt(right))) {
                right--;
            } else {
                if (toLowerCase(s.charAt(left)) != toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
    private boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c - ('A' - 'a'));
        }
        return c;
    }
}