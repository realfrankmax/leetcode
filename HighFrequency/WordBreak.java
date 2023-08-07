package HighFrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 140. Word Break II
 */
public class WordBreak {
    public static void main(String[] args) {}

    // Time: O(n^2)
    // Could use a Map to save breaked words, and look up if s has been broken down.
    public List<String> wordBreak(String s, List<String> wordDict) {
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
        return spacedWords;
    }
}
