package LinkedList;

/**
 * @leetcode: 234. Palindrome Linked List
 */
public class IsPalindrome {
    public static void main(String[] args) {}

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Keep len(firstHalf) <= len(secondHalf)
        ListNode mid = split(head);
        ListNode firstHead = head;
        ListNode secondHead = reverse(mid);
        while (firstHead != null && secondHead != null) {
            if (firstHead.val != secondHead.val) {
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return firstHead == null;
    }
    // Keep len(firstHalf) <= len(secondHalf)
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
