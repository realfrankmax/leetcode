package LinkedList;

/**
 * @leetcode: 143. Reorder List
 */
public class ReorderList {
    public static void main(String[] args) {}

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = split(head);
        ListNode firstHead = head;
        ListNode secondHead = reverse(mid);
        while (firstHead != null) {
            ListNode t1 = firstHead.next;
            firstHead.next = secondHead;
            ListNode t2 = secondHead.next;
            if (t1 == null) {
                break;
            }
            secondHead.next = t1;
            firstHead = t1;
            secondHead = t2;
        }
    }
    // Second half >= first half
    private ListNode split(ListNode n) {
        if (n == null || n.next == null) {
            return n;
        }
        ListNode prev = new ListNode(0);
        prev.next = n;
        while (n != null && n.next != null) {
            prev = prev.next;
            n = n.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null;
        return mid;
    }
    private ListNode reverse(ListNode n) {
        if (n == null || n.next == null) {
            return n;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = n;
        while (n.next != null) {
            ListNode t = tempHead.next;
            tempHead.next = n.next;
            n.next = n.next.next;
            tempHead.next.next = t;
        }
        return tempHead.next;
    }
}
