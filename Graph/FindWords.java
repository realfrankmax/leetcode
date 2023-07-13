package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: Word Search II
 */
public class FindWords {
    public static void main(String[] args) {}

    List<String> res;
    // Note: Avoid reusing characters, finding duplicate strings
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, Trie node) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || !node.children.containsKey(board[r][c])) {
            return ;
        }
        Trie curr = node.children.get(board[r][c]);
        if (curr.s != null) {
            // There could be duplicate strings, so mark the used strings before going to next cell.
            res.add(curr.s);
            curr.s = null;
        }
        // Avoid reuse characters
        char cache = board[r][c];
        board[r][c] = '.';
        int[] dir = new int[] {-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            dfs(board, r+dir[i], c+dir[i+1], curr);
        }
        board[r][c] = cache;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String w : words) {
            Trie curr = root;
            for (char c : w.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Trie());
                }
                curr = curr.children.get(c);
            }
            curr.s = w;
        }
        return root;
    }

    class Trie {
        String s;
        Map<Character, Trie> children;
        public Trie() {
            children = new HashMap<>();
        }
    }
}