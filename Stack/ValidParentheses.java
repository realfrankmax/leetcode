package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @leetcode: 20. Valid Parentheses
 */
public class ValidParentheses {
    public static void main(String[] args) {}

    public boolean isValid(String s) {
        Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> unmatched = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (unmatched.isEmpty() || unmatched.removeLast() != pairs.get(c)) {
                    return false;
                }
            } else {
                unmatched.addLast(c);
            }
        }
        return unmatched.isEmpty();
    }
}