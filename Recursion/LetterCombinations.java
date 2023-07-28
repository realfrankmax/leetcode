package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 17. Letter Combinations of a Phone Number
 */
public class LetterCombinations {
    public static void main(String[] args) {}

    private String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res;
    private String digits;

    public List<String> letterCombinations(String digits) {
        this.res = new ArrayList<>();
        if (digits.length() == 0) {
            return this.res;
        }
        this.digits = digits;
        
        build(new StringBuilder(), 0);
        return this.res;
    }
    private void build(StringBuilder sb, int pos) {
        if (sb.length() == this.digits.length()) {
            this.res.add(sb.toString());
            return ;
        }
        char[] chars = this.dict[this.digits.charAt(pos) - '2'].toCharArray();
        for (char c : chars) {
            sb.append(c);
            build(sb, pos+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
