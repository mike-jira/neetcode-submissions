/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        // allocate
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode subHead = prev.next;

        ListNode subTail = subHead;
        for (int i = left; i < right; i++) {
            subTail = subTail.next;
        }

        // save the next of rightest
        ListNode tail = subTail.next;
        // disconnect next of the rightest
        subTail.next = null;

        ListNode newHead = null;
        ListNode current = subHead;
        while (current != null) {
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }

        // now connect node
        prev.next = newHead;
        subHead.next = tail;

        return dummy.next;
    }
}