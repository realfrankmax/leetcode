package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 792. Number of Matching Subsequences
 */
public class NumMatchingSubseq {
    public static void main(String[] args) {}
    // Time O(n*len(s)): n is len of words
    /**
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubseq(s, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSubseq(String s, String sub) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < sub.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == sub.length();
    }
    */

    // Time O(n*len(s)): n is len of words
    // But on average is much better than commented solution
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        List<List<int[]>> buckets = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            int pos = c - 'a';
            buckets.get(pos).add(new int[]{i, 0});
        }
        for (char c : s.toCharArray()) {
            List<int[]> curr = buckets.get(c-'a');
            buckets.set(c-'a', new ArrayList<>());
            for (int[] word : curr) {
                if (word[1] == words[word[0]].length()-1) {
                    count++;
                } else {
                    int next = words[word[0]].charAt(word[1]+1) - 'a';
                    buckets.get(next).add(new int[]{word[0], word[1]+1});
                }
            }
        }
        return count;
    }
}
