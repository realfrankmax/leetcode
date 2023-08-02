package DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @leetcode: 139. Word Break
 */
public class WordBreak {
    public static void main(String[] args) {}

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
