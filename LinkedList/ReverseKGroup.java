package LinkedList;

/**
 * @leetcode: 25. Reverse Nodes in k-Group
 */
public class ReverseKGroup {
    public static void main(String[] args) {}

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        if (!canReverse(head, k)) {
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        int count = k-1;
        while (count != 0) {
            ListNode t = tempHead.next;
            tempHead.next = head.next;
            head.next = head.next.next;
            tempHead.next.next = t;
            count--;
        }
        head.next = reverseKGroup(head.next, k);
        return tempHead.next;
    }

    private boolean canReverse(ListNode n, int k) {
        while (k != 0 && n != null) {
            n = n.next;
            k--;
        }
        return k == 0;
    }
}