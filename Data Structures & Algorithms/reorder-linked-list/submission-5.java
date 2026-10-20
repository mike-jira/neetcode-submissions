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
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode prep = slow.next;
        // cut lose old connection
        slow.next = null;


        // perform reverse linked list of second half
        ListNode newHead = null;
        while (prep != null) {
            ListNode next = prep.next;
            prep.next = newHead;
            newHead = prep;
            prep = next;
        }

        while (newHead != null) {
            ListNode nextNewHead = newHead.next;
            ListNode nextHead = head.next;

            newHead.next = nextHead;
            head.next = newHead;
            head = nextHead;
            newHead = nextNewHead;
        }
    }
}
