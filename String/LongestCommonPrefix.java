package String;

/**
 * @leetcode: Longest Common Prefix
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {}

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonPrefix(prefix, strs[i]);
            if (prefix.equals("")) {
                return "";
            }
        }
        return prefix;
    }

    private String getCommonPrefix(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }
        return s1.substring(0, i);
    }
}