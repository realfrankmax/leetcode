package String;

/**
 * @leetcode: 10. Regular Expression Matching
 */
public class RegexMatching {
    public static void main(String[] args) {}

    Boolean[][] cache;
    // Time O(len(s) * len(p))
    public boolean isMatch(String s, String p) {
        cache = new Boolean[s.length()+1][p.length()+1];
        return helper(s, 0, p, 0);
    }
    private boolean helper(String s, int si, String p, int pi) {
        if (cache[si][pi] != null) {
            return cache[si][pi];
        }
        if (pi == p.length()) {
            cache[si][pi] = si == s.length();
            return cache[si][pi];
        }
        boolean firstMatch = si != s.length() && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '.');
        boolean res;
        if (pi+1 < p.length() && p.charAt(pi+1) == '*') {
            res = helper(s, si, p, pi+2) || (firstMatch && helper(s, si+1, p, pi));
        } else {
            res = firstMatch && helper(s, si+1, p, pi+1);
        }
        cache[si][pi] = res;
        return res;
    }

}
