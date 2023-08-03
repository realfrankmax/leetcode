package HighFrequency;

/**
 * @leetcode: 921. Minimum Add to Make Parentheses Valid
 */
public class MinAddToMakeValid {
    public static void main(String[] args) {}

    public int minAddToMakeValid(String s) {
        int countLeft = 0;
        int countRight = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                countLeft++;
            } else if (c == ')') {
                if (countLeft != 0) {
                    countLeft--;
                } else {
                    countRight++;
                }
            }
        }
        return countLeft+countRight;
    }
}
