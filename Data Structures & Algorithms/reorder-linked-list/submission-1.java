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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half = slow.next;
        slow.next = null;
        ListNode swap = null;

        while (half != null) {
            ListNode next = half.next;
            half.next = swap;
            swap = half;
            half = next;
        }
        // connect
        while (swap != null) {
            ListNode nextSwap = swap.next;
            ListNode next = head.next;
            // operate
            head.next = swap;
            head = head.next;
            head.next = next;
            head = head.next;
            swap = nextSwap;
        }
    }
}
