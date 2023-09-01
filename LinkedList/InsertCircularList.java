package LinkedList;

/**
 * @leetcode: 708. Insert into a Sorted Circular Linked List
 */
public class InsertCircularList {
    public static void main(String[] args) {}

    static class Node {
        public int val;
        public Node next;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newHead = new Node(insertVal);
            newHead.next = newHead;
            return newHead;
        }
        Node temp = head;
        while (true) {
            if (temp.val < temp.next.val) {
                if (temp.val <= insertVal && insertVal <= temp.next.val) {
                    temp.next = new Node(insertVal, temp.next);
                    break;
                }
            } else if (temp.val > temp.next.val) {
                if (insertVal >= temp.val || insertVal <= temp.next.val) {
                    temp.next = new Node(insertVal, temp.next);
                    break;
                }
            } else {
                if (temp.next == head) {
                    temp.next = new Node(insertVal, temp.next);
                    break;
                }
            }
            temp = temp.next;
        }
        return head;
    }
}