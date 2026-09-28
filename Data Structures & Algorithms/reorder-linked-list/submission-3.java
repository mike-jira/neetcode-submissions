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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode prep = slow.next;
        // cut lose old connection
        slow.next = null;
        // start reverse swapNodes
        ListNode secondHalf = null;

        while (prep != null) {
            ListNode next = prep.next;
            prep.next = secondHalf;
            secondHalf = prep;
            prep = next;
        }

        while (secondHalf != null) {
            ListNode nextHead = head.next;
            ListNode secondHalfNext = secondHalf.next;
            head.next = secondHalf;
            head = head.next;
            head.next = nextHead;
            head = head.next;
            secondHalf = secondHalfNext;
        }
    }
}
