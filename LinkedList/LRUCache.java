package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 146. LRU Cache
 */
public class LRUCache {
    public static void main(String[] args) {}

    public class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> storage;
    // Queue-alike structure. LRU node is at head position.
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (!storage.containsKey(key)) {
            return -1;
        }
        Node node = storage.get(key);
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node;
        if (storage.containsKey(key)) {
            node = storage.get(key);
            node.val = value;
        } else {
            if (capacity == this.storage.size()) {
                // remove head.next
                this.storage.remove(this.head.next.key);
                this.head.next = this.head.next.next;
                this.head.next.prev = this.head;
            }
            node = new Node(key, value);
            storage.put(key, node);
        }
        moveToTail(node);
    }

    private void moveToTail(Node node) {
        // Because it is doubly linked list, 6 operations are needed.
        // Delete from currnt position
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        // Move to tail
        node.next = this.tail;
        node.prev = this.tail.prev;
        this.tail.prev = node;
        node.prev.next = node;
    }
}
