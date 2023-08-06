package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 242. Valid Anagram
 */
public class IsAnagram {
    public static void main(String[] args) {}

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0)-1);
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}