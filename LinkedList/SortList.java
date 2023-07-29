package LinkedList;

/**
 * @leetcode: 148. Sort List
 */
public class SortList {
    public static void main(String[] args) {}

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = split(head);
        ListNode firstHalfSorted = sortList(head);
        ListNode secondHalfSorted = sortList(mid);
        return merge(firstHalfSorted, secondHalfSorted);
    }

    private ListNode split(ListNode n) {
        if (n == null || n.next == null) {
            return n;
        }
        ListNode prev = new ListNode(0);
        prev.next = n;
        while (n != null && n.next != null) {
            n = n.next.next;
            prev = prev.next;
        }
        ListNode mid = prev.next;
        prev.next = null;
        return mid;
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode tempHead = new ListNode(0);
        ListNode pointer = tempHead;
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                pointer.next = n2;
                n2 = null;
            } else if (n2 == null) {
                pointer.next = n1;
                n1 = null;
            } else {
                if (n1.val < n2.val) {
                    pointer.next = n1;
                    n1 = n1.next;
                } else {
                    pointer.next = n2;
                    n2 = n2.next;
                }
                pointer = pointer.next;
            }
        }
        return tempHead.next;
    }
}