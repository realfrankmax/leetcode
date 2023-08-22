package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * @leetcode: 772. Basic Calculator III
 */
public class BasicCalculatorIII {
    public static void main(String[] args) {}

    Set<Character> ops = Set.of('+', '-', '*', '/');
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
            if (this.ops.contains(c) || c == ')' || p[0] == s.length()-1){
                switch (op) {
                    case '+' :
                        nums.addLast(curr);
                        break;
                    case '-' :
                        nums.addLast(-curr);
                        break;
                    case '*':
                        nums.addLast(nums.removeLast() * curr);
                        break;
                    case '/':
                        nums.addLast(nums.removeLast() / curr);
                        break;
                }
                if (c == ')') {
                    break;
                }
                curr = 0;
                op = c;
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
