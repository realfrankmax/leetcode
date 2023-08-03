package HighFrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 301. Remove Invalid Parentheses
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {}

    private List<String> res;
    public List<String> removeInvalidParentheses(String s) {
        this.res = new ArrayList<>();
        remove(s, 0, 0, '(', ')');
        return this.res;    
    }

    // Set logic to remove right char, because it is always true
    // that additional right char should be removed.
    // When (() has been checked, there could be more ),
    // When ()) has been checked, one ) MUST be removed.
    private void remove(String s, int start, int removeStart, char left, char right) {
        int diff = 0;
        int i = start;
        while(i < s.length()) {
            char c = s.charAt(i);
            if (c == left) {
                diff++;
            } else if (c == right) {
                diff--;
            }
            if (diff < 0) {
                break;
            }
            i++;
        }
        if (diff < 0) {
            // Have to remove one char: right
            for (int j = removeStart; j <= i; j++) {
                // Need to remove one right char from every right char group. Like ), or ))
                if (s.charAt(j) == right && (j == removeStart || s.charAt(j-1) != right)) {
                    remove(s.substring(0, j)+s.substring(j+1), i, j, left, right);
                }
            }
            // Once a unmatched char right is removed, we could stop
            // because the rest of the string will be checked in recursion above. 
        } else {
            String reversed = new StringBuilder(s).reverse().toString();
            if (left == '(') {
                // It means left count > right count
                // Now it is to check left
                remove(reversed, 0, 0, ')', '(');
            } else {
                // Both have been checked.
                this.res.add(reversed);
            }
        }
    }
}