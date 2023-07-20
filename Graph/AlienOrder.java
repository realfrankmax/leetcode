package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode: Alien Dictionary
 */
public class AlienOrder {
    public static void main(String[] args) {}

    public String alienOrder(String[] words) {
        // From key to set of letters after the key.
        Map<Character, Set<Character>> graph = new HashMap<>();
        // Count of letters before key.
        Map<Character, Integer> count = new HashMap<>();
        // The whole letter set
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String a = words[i];
            for (char c : a.toCharArray()) {
                letters.add(c);
            }
            if (i < words.length-1) {
                String b = words[i+1];
                int m = 0;
                int n = 0;
                while (m < a.length() && n < b.length()) {
                    if (a.charAt(m) != b.charAt(n)) {
                        graph.computeIfAbsent(a.charAt(m), x -> new HashSet<>());
                        // Avoid double count on duplicates.
                        if (graph.get(a.charAt(m)).add(b.charAt(n))) {
                            count.put(b.charAt(n), count.getOrDefault(b.charAt(n), 0)+1);
                        }
                        break;
                    }
                    m++;
                    n++;
                }
                // Avoid case when "abc" is before "ab"
                if (n == b.length() && m < a.length()) {
                    return "";
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : letters) {
            if (!count.containsKey(c)) {
                q.add(c);
            }
        }
        // Initial letters order couldn't be decided if there are multiple.
        // if (q.size() != 1) {
        //     return "";
        // }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.remove();
            sb.append(curr);
            for (char next : graph.getOrDefault(curr, new HashSet<>())) {
                if (count.containsKey(next)) {
                    count.put(next, count.get(next)-1);
                    if (count.get(next) == 0) {
                        q.add(next);
                    }
                }
            }
        }
        return sb.length() == letters.size() ? sb.toString() : "";
    }
}