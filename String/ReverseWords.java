package String;

/**
 * @leetcode: 151. Reverse Words in a String
 */
public class ReverseWords {
    public static void main(String[] args) {}

    // Time O(N)
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        s = " " + s;
        int end = s.length()-1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (i == end) {
                    end = i -1;
                } else {
                    if (builder.length() != 0) {
                        builder.append(" ");
                    }
                    builder.append(s.substring(i+1, end+1));
                    end = i-1;
                }
            }
        }
        return builder.toString();
    }
}