package Array;

/**
 * @leetcode: 844. Backspace String Compare
 */
public class BackspaceCompare {
    public static void main(String[] args) {}

    // Space O(1)
    // Compare from right to left
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        char bs = '#';
        while (i >= 0 || j >= 0) {
            int count = 0;
            while (i >= 0) {
                if (s.charAt(i) == bs) {
                    i--;
                    count++;
                } else if (count > 0) {
                    i--;
                    count--;
                } else {
                    break;
                }
            }
            count = 0;
            while (j >= 0) {
                if (t.charAt(j) == bs) {
                    j--;
                    count++;
                } else if (count > 0) {
                    j--;
                    count--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
    // Space O(n)

    /**

    public boolean backspaceCompare(String s, String t) {
        return print(s).equals(print(t));
    }
    private String print(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (builder.length() != 0) {
                    builder.deleteCharAt(builder.length()-1);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
    */
}