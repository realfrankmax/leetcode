package String;

/**
 * @leetcode: 5. Longest Palindromic Substring
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {}

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String p1 = expand(s, i, i);
            String p2 = expand(s, i,i+1);
            if (p1.length() > res.length()) {
                res = p1;
            }
            if (p2.length() > res.length()) {
                res = p2;
            }
        }
        return res;
    }

    private String expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}