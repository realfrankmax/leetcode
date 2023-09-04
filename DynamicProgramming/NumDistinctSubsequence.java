package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 115. Distinct Subsequences
 */
public class NumDistinctSubsequence {
    public static void main(String[] args) {}

    // Time O(len(s)*len(t))
    // Space O(len(s)*len(t))
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        long[][] count = new long[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            count[i][n] = 1;
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                count[i][j] = count[i+1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    count[i][j] += count[i+1][j+1];
                }
            }
        }
        return count[0][0] > Integer.MAX_VALUE ? -1 : (int)count[0][0];
    }
    // Time O(len(s)*len(t))
    // Space O(len(s)*len(t))
    Map<State, Integer> cache;
    public int numDistinct_recursion(String s, String t) {
        this.cache = new HashMap<>();
        return check(s, t, 0, 0);
    }

    private int check(String s, String t, int i, int j) {
        State curr = new State(i, j);
        if (this.cache.containsKey(curr)) {
            return this.cache.get(curr);
        }
        if (i == s.length() || j == t.length() || s.length()-i < t.length()-j) {
            return j == t.length() ? 1 : 0;
        }
        int count = check(s, t, i+1, j);
        if (s.charAt(i) == t.charAt(j)) {
            count += check(s, t, i+1, j+1);
        }
        this.cache.put(curr, count);
        return count;
    }

    static class State {
        int i;
        int j;
        public State(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}