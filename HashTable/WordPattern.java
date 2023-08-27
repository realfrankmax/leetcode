package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @leetcode: 290. Word Pattern
 */
public class WordPattern {
    public static void main(String[] args) {}

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pairs = new HashMap<>();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            String curr = strs[i];
            if (pairs.containsKey(c)) {
                if (!pairs.get(c).equals(curr)) {
                    return false;
                }
            } else {
                if (!seen.add(curr)) {
                    return false;
                }
                pairs.put(c, curr);
            }
        }
        return true;
    }
}
