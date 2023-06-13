package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: Minimum Window Substring
 */
public class MinWindow {
    public static void main(String[] args) {}

    public String minWindow(String s, String t) {
        // The substring from s could contains more chars than the one in t
        // substring: ABBC, t: ABC
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : t.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0)+1);
        }
        int start = 0;
        int len = Integer.MAX_VALUE;
        int head = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (dict.containsKey(curr)) {
                if (dict.get(curr) > 0) {
                    count++;
                }
                dict.put(curr, dict.get(curr)-1);

                // Move start to find the first char in t from s
                // Once it is removed, we could move on to find another substring.
                while (count == t.length()) {
                    if (i-start+1 < len) {
                        len = i-start+1;
                        head = start;
                    }
                    char st = s.charAt(start);
                    if (dict.containsKey(st)) {
                        dict.put(st, dict.get(st)+1);
                        // break the while loop
                        if (dict.get(st) > 0) {
                            count--;
                        }
                    }
                    start++;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head+len);
    }
}