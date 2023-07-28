package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 22. Generate Parentheses
 */
public class GenerateParenthesis {
    public static void main(String[] args) {}

    private List<String> res;
    // Time: Exponential Time O(2^2n)
    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        build(new StringBuilder(), n, n);
        return this.res;    
    }
    private void build(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            this.res.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            build(sb, left-1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (left < right) {
            sb.append(")");
            build(sb, left, right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
