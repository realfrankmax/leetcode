package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * @leetcode: 150. Evaluate Reverse Polish Notation
 */
public class EvalRPN {
    public static void main(String[] args) {}

    Set<String> operators = Set.of("+", "-", "*", "/");
    public int evalRPN(String[] tokens) {
        Deque<Integer> buffer = new ArrayDeque<>();
        for (String s : tokens) {
            if (this.operators.contains(s)) {
                buffer.addLast(calculate(s, buffer.removeLast(), buffer.removeLast()));
            } else {
                buffer.addLast(Integer.parseInt(s));
            }
        }
        return buffer.removeLast();
    }
    private int calculate(String op, int a, int b) {
        switch (op) {
            case "+":
                return a+b;
            case "-":
                return b-a;
            case "*":
                return a*b;
            case "/":
                return b/a;
            default:
                return 0;
        }
    }
}
