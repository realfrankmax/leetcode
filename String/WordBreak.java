package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: 140. Word Break II
 */
public class WordBreak {
    public static void main(String[] args) {}

    // Time: O(n^2)
    // Could use a Map to save breaked words, and look up if s has been broken down.
    Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> spacedWords = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (wordDict.contains(sub)) {
                if (sub.equals(s)) {
                    spacedWords.add(s);
                    break;
                }
                List<String> rest = wordBreak(s.substring(i), wordDict);
                for (String r : rest) {
                    spacedWords.add(sub + " " + r);
                }
            }
        }
        cache.put(s, spacedWords);
        return spacedWords;
    }
}
