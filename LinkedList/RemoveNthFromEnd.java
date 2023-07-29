package LinkedList;

/**
 * @leetcode: 19. Remove Nth Node From End of List
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {}

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        while (n != 0) {
            head = head.next;
            n--;
        }
        ListNode pointer = tempHead;
        while (head != null) {
            pointer = pointer.next;
            head = head.next;
        }
        pointer.next = pointer.next.next;
        return tempHead.next;
    }
}