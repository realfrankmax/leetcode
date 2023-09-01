package Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 211. Design Add and Search Words Data Structure
 */
public class WordDictionary {
    public static void main(String[] args) {}

    private Node root;
    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            curr.children.computeIfAbsent(c, x -> new Node());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return searchWithNode(word, root);
    }

    private boolean searchWithNode(String word, Node node) {
        if (word.length() == 0) {
            return node.isWord;
        }
        char c = word.charAt(0);
        if (c == '.') {
            for (char key : node.children.keySet()) {
                if (searchWithNode(word.substring(1), node.children.get(key))) {
                    return true;
                }
            }
            return false;
        } else {
            return node.children.containsKey(c) && searchWithNode(word.substring(1), node.children.get(c));
        }
    }

    static class Node {
        boolean isWord;
        Map<Character, Node> children;
        public Node() {
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }
}
