package String;

/**
 * @leetcode: 44. Wildcard Matching
 */
public class WildcardMatching {
    public static void main(String[] args) {}

    Boolean[][] cache;
    // Time O(len(s) * len(p))
    // Same solution as 10. Regular Expression Matching
    public boolean isMatch(String s, String p) {
        this.cache = new Boolean[s.length()+1][p.length()+1];
        return helper(s, 0, p, 0);
    }
    private boolean helper (String s, int si, String p, int pi) {
        if (this.cache[si][pi] != null) {
            return this.cache[si][pi];
        }
        if (pi == p.length()) {
            this.cache[si][pi] = si == s.length();
            return this.cache[si][pi];
        }
        boolean firstMatch = si != s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?' || p.charAt(pi) == '*');
        boolean res = false;
        if (p.charAt(pi) == '*') {
            res =  helper(s, si, p, pi+1) || (firstMatch && helper(s, si+1, p, pi));
        } else {
            res = firstMatch && helper(s, si+1, p, pi+1);
        }
        this.cache[si][pi] = res;
        return res;
    }
}