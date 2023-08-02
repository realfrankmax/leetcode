package Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 208. Implement Trie (Prefix Tree)
 */
public class Trie {
    public static void main(String[] args) {}

    private Node root;

    public Trie() {
        this.root = new Node();    
    }
    
    public void insert(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            curr.children.computeIfAbsent(c, x -> new Node());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = this.root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }

    class Node {
        boolean isWord;
        Map<Character, Node> children;
        public Node() {
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }
}