package LinkedList;

/**
 * @leetcode: 21. Merge Two Sorted Lists
 */
public class MergeTwoLists {
    public static void main(String[] args) {}

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                pointer.next = list2;
                list2 = null;
            } else if (list2 == null) {
                pointer.next = list1;
                list1 = null;
            } else {
                if (list1.val > list2.val) {
                    pointer.next = list2;
                    list2 = list2.next;
                } else {
                    pointer.next = list1;
                    list1 = list1.next;
                }
                pointer = pointer.next;
            }
        }
        return head.next;
    }
}
