package LinkedList;

/**
 * @leetcode: 876. Middle of the Linked List
 */
public class MiddleNode {
    public static void main(String[] args) {}

    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}