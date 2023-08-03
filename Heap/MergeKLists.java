package Heap;

import java.util.PriorityQueue;

/**
 * @leetcode: 23. Merge k Sorted Lists
 */
public class MergeKLists {
    public static void main(String[] args) {}

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> KNodes = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        ListNode tempHead = new ListNode(0);
        ListNode pointer = tempHead;
        for (ListNode n : lists) {
            if (n != null) {
                KNodes.offer(n);
            }
        }
        while (!KNodes.isEmpty()) {
            ListNode curr = KNodes.poll();
            pointer.next = curr;
            pointer = pointer.next;
            if (curr.next != null) {
                KNodes.offer(curr.next);
            }
        }
        return tempHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}