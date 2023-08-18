package LinkedList;

/**
 * @leetcode: 1290. Convert Binary Number in a Linked List to Integer
 */
public class GetDecimalValue {
    public static void main(String[] args) {}

    public int getDecimalValue(ListNode head) {
        int val = 0;
        while (head != null) {
            val = 2*val + head.val;
            head = head.next;
        }
        return val;
    }
}
