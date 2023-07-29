package LinkedList;

/**
 * @leetcode: 61. Rotate List
 */
public class RotateRight {
    public static void main(String[] args) {}

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = getLength(head);
        k = k%len;
        if (k == 0) {
            return head;
        }
        ListNode pointer = head;
        while (k != 0) {
            pointer = pointer.next;
            k--;
        }
        ListNode newTail = head;
        while (pointer.next != null) {
            newTail = newTail.next;
            pointer = pointer.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        pointer.next = head;
        return newHead;
    }

    private int getLength(ListNode n) {
        int len = 0;
        while (n != null) {
            len++;
            n = n.next;
        }
        return len;
    }
}