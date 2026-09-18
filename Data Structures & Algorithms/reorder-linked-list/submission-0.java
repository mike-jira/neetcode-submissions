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
        ListNode fast = head;
        ListNode slow = head;
        ListNode newHead = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prep = slow.next;
        // cut lose old connection
        slow.next = null;
        // start reverse swapNodes
        ListNode swapNode = null;
        while (prep != null) {
            ListNode next = prep.next;
            prep.next = swapNode;
            swapNode = prep;
            prep = next;
        }

        while (swapNode != null) {
            // store next value
            ListNode next = head.next;
            ListNode nextToSwap = swapNode.next;
            // operation
            head.next = swapNode;
            head = head.next;
            head.next = next;
            head = head.next;
            // cut connection
            swapNode = nextToSwap;
        }
    }
}
