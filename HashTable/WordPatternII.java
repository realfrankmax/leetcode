package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @leetcode: 291. Word Pattern II
 */
public class WordPatternII {
    public static void main(String[] args) {}

    Map<Character, String> pairs;
    Set<String> seen;
    public boolean wordPatternMatch(String pattern, String s) {
        this.pairs = new HashMap<>();
        this.seen = new HashSet<>();
        return check(pattern, 0, s, 0);
    }
    private boolean check(String pattern, int i, String s, int j) {
        if (i == pattern.length() && j == s.length()) {
            return true;
        } else if (i == pattern.length() || j == s.length()) {
            return false;
        }
        char curr = pattern.charAt(i);
        if (this.pairs.containsKey(curr)) {
            if (s.startsWith(this.pairs.get(curr), j)) {
                return check(pattern, i+1, s, j+this.pairs.get(curr).length());
            }
            return false;
        } else {
            for (int k = j+1; k <= s.length(); k++) {
                String next = s.substring(j, k);
                if (this.seen.contains(next)) {
                    continue;
                }
                this.seen.add(next);
                this.pairs.put(curr, next);
                if (check(pattern, i+1, s, k)) {
                    return true;
                }
                this.seen.remove(next);
                this.pairs.remove(curr);
            }
        }
        return false;
    }
}
