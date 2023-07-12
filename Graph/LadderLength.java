package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode: Word Ladder
 */
public class LadderLength {
    public static void main(String[] args) {}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int ladder = 1;
        Set<String> used = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                String curr = q.remove();
                if (curr.equals(endWord)) {
                    return ladder;
                }
                for (String w : wordList) {
                    if (getDistance(w, curr) == 1 && used.add(w)) {
                        q.add(w);
                    }
                }
            }
            ladder++;
        }
        return 0;
    }
    private int getDistance(String s1, String s2) {
        int c = 0;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                c++;
            }
        }
        return c;
    }
}