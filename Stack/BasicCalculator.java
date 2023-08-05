package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

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
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Integer> signs = new ArrayDeque<>();
        int curr = 0;
        int sign = 1;
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curr = 10*curr + Character.getNumericValue(c);
            } else if (c == '+' || c == '-') {
                sum += sign*curr;
                sign = c == '+' ? 1 : -1;
                curr = 0;
            } else if (c == '(') {
                nums.addLast(sum);
                signs.addLast(sign);
                sum = 0;
                sign = 1;
            } else if (c == ')') {
                sum += sign*curr;
                sum = signs.removeLast() * sum + nums.removeLast();
                curr = 0;
            }
        }
        sum += sign*curr;
        return sum;
    }
}