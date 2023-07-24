package HighFrequency;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: Convert Binary Search Tree to Sorted Doubly Linked List
 */
public class TreeToDoublyList {
    public static void main(String[] args) {}

    // Normal inorder traversal iterative version
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deck = new ArrayDeque<>();
        Node pre = null;
        Node head = null;
        while (root != null || !deck.isEmpty()) {
            if (root != null) {
                deck.addLast(root);
                root = root.left;
            } else {
                Node curr = deck.removeLast();
                if (pre == null) {
                    head = curr;
                } else {
                    // Double linking
                    pre.right = curr;
                    curr.left = pre;
                }
                pre = curr;
                root = curr.right;
            }
        }
        // Link head with last node
        pre.right = head;
        head.left = pre;
        return head;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}