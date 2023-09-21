package String;

/**
 * @leetcode: 316. Remove Duplicate Letters
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {}

    // Time O(26*N)
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        int small = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(small)) {
                small = i;
            }
            if (--count[s.charAt(i)-'a'] == 0) {
                break;
            }
        }
        return s.charAt(small) + removeDuplicateLetters(s.substring(small+1).replaceAll(""+s.charAt(small), ""));
    }
}