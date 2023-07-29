package LinkedList;

/**
 * @leetcode: 24. Swap Nodes in Pairs
 */
public class SwapPairs {
    public static void main(String[] args) {}

    public ListNode swapPairs(ListNode head) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead;
        while (head != null && head.next != null) {
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = head;
            pre = head;
            head = head.next;
        }
        return tempHead.next;
    }
}