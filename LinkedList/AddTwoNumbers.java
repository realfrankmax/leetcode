package LinkedList;

/**
 * @leetcode: 2. Add Two Numbers
 */
public class AddTwoNumbers {
    public static void main(String[] args) {}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            pointer.next = new ListNode(sum%10);
            carry = sum / 10;
            pointer = pointer.next;
        }
        return head.next;
    }
}
