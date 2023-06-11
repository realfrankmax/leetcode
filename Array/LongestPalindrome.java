package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @leetcode: Longest Palindrome
 */
public class LongestPalindrome {
    public static void main(String[] args) {}

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                count+=2;
                set.remove(c);
            }
        }
        return set.isEmpty() ? count : count+1;
    }
}