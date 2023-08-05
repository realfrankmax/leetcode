package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 227.Basic Calculator II
 */
public class Calculate {
    public static void main(String[] args) {}

    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        char op = '+';
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                curr = 10*curr + c - '0';
            }
            if (i == s.length()-1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if (op == '+') {
                    nums.addLast(curr);
                } else if (op == '-') {
                    nums.addLast(-curr);
                } else if (op == '*') {
                    nums.addLast(curr * nums.removeLast());
                } else if (op == '/') {
                    nums.addLast(nums.removeLast() / curr);
                }
                curr = 0;
                op = c;
            }
        }
        int res = 0;
        while (!nums.isEmpty()) {
            res += nums.removeLast();
        }
        return res;
    }
}