package LinkedList;

/**
 * @leetcode: 328. Odd Even Linked List
 */
public class OddEvenList {
    public static void main(String[] args) {}

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddPointer = odd;
        ListNode even = new ListNode(0);
        ListNode evenPointer = even;
        int i = 1;
        while (head != null) {
            if (i%2 == 0) {
                evenPointer.next = head;
                head = head.next;
                evenPointer = evenPointer.next;
                evenPointer.next = null;
            } else {
                oddPointer.next = head;
                head = head.next;
                oddPointer = oddPointer.next;
                oddPointer.next = null;
            }
            i++;
        }
        oddPointer.next = even.next;
        return odd.next;
    }
}
