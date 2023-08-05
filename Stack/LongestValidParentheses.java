package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 32. Longest Valid Parentheses
 */
public class LongestValidParentheses {
    public static void main(String[] args) {}

    // Save the positions
    // Pop the matched parentheses and the top of the stack is the first unmatched one.
    // Use that to calculate the len of matched parentheses.
    public int longestValidParentheses(String s) {
        Deque<Integer> pos = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && (!pos.isEmpty() && s.charAt(pos.getLast()) == '(')) {
                pos.removeLast();
                max = Math.max(max, i - (pos.isEmpty() ? -1 : pos.getLast()));
            } else {
                pos.addLast(i);
            }
        }
        return max;
    }
    
}