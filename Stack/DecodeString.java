package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 394. Decode String
 */
public class DecodeString {
    public static void main(String[] args) {}

    public String decodeString(String s) {
        Deque<Character> buffer = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                buffer.addLast(c);
            } else {
                // Get repeated string
                StringBuilder str = new StringBuilder();
                while (!buffer.isEmpty() && buffer.getLast() != '[') {
                    str.append(buffer.removeLast());
                }
                buffer.removeLast(); // remove '['
                // Get number of copies
                StringBuilder num = new StringBuilder();
                while (!buffer.isEmpty() && Character.isDigit(buffer.getLast())) {
                    num.append(Character.getNumericValue(buffer.removeLast()));
                }
                int repeat = Integer.parseInt(num.reverse().toString());
                String curr = str.toString();
                while (--repeat != 0) {
                    str.append(curr);
                }
                // Push str back
                for (int j = str.length()-1; j >= 0; j--) {
                    buffer.addLast(str.charAt(j));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!buffer.isEmpty()) {
            res.append(buffer.removeFirst());
        }
        return res.toString();
    }
}