package String;

/**
 * @leetcode: 856. Score of Parentheses
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {}

    public int scoreOfParentheses(String s) {
        int depth = 0;
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i-1) == '(') {
                    // score += (1 << depth);
                    score += Math.pow(2, depth);
                }
            }
        }
        return score;
    }
}