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
        // get left and prev pointer to it position
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode l = head;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
            l = l.next;
        }

        // get right position to position
        ListNode r = l;
        for (int i = left; i < right; i++) {
            r = r.next;
        }
        // save tail
        ListNode savedTail = r.next;
        r.next = null;
        ListNode newHead = null;
        // use current to save l pointer for use to connect node later
        ListNode current = l;

        // start reverse linkedlist
        while (current != null) {
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }

        // now connect to origin node
        prev.next = newHead;
        l.next = savedTail;

        return dummy.next;
    }
}