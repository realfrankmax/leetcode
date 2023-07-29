package LinkedList;

/**
 * @leetcode: 206. Reverse Linked List
 */
public class ReverseList {
    public static void main(String[] args) {}

    // head pointer never changes
    public ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        while (head!= null && head.next != null) {
            ListNode t = temp.next;
            temp.next = head.next;
            head.next = head.next.next;
            temp.next.next = t;
        }
        return temp.next;
    }
}