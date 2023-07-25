package HighFrequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 138. Copy List with Random Pointer
 */
public class CopyRandomList {
    public static void main(String[] args) {}

    public Node copyRandomList(Node head) {
        Map<Node, Node> copies = new HashMap<>();
        Node t = head;
        while (t != null) {
            if (!copies.containsKey(t)) {
                copies.put(t, new Node(t.val));
            }
            if (t.next != null) {
                if (!copies.containsKey(t.next)) {
                    copies.put(t.next, new Node(t.next.val));
                }
                copies.get(t).next = copies.get(t.next);
            }
            if (t.random != null) {
                if(!copies.containsKey(t.random)) {
                    copies.put(t.random, new Node(t.random.val));
                }
                copies.get(t).random = copies.get(t.random);
            }
            t = t.next;
        }
        return copies.get(head);
    }
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}