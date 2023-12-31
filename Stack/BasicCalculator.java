package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * @leetcode: 224. Basic Calculator
 */
public class BasicCalculator {
    public static void main(String[] args) {}

    /**
     * s consists of digits, '+', '-', '(', ')', and ' '.
     * s represents a valid expression.
     * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
     * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
     */
    // Same solution as 772
    Set<Character> ops = Set.of('+', '-');
    public int calculate(String s) {
        int[] p = new int[1];
        return calculateFrom(s, p);
    }
    private int calculateFrom(String s, int[] p) {
        Deque<Integer> nums = new ArrayDeque<>();
        int curr = 0;
        char op = '+';
        while (p[0] < s.length()) {
            char c = s.charAt(p[0]);
            if (Character.isDigit(c)) {
                curr = 10 * curr + Character.getNumericValue(c);
            } else if (c == '(') {
                p[0]++;
                curr = calculateFrom(s, p);
            }
            if (p[0] == s.length()-1 || this.ops.contains(c) || c == ')') {
                switch (op) {
                    case '+':
                        nums.addLast(curr);
                        break;
                    case '-':
                        nums.addLast(-curr);
                        break;
                }
                if (c == ')') {
                    break;
                }
                op = c;
                curr = 0;
            }
            p[0]++;
        }
        int res = 0;
        while (!nums.isEmpty()) {
            res += nums.removeLast();
        }
        return res;
    }
}