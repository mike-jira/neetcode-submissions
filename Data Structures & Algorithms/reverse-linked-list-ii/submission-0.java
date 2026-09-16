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
        
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode subHead = prev.next;
        ListNode subTail = subHead;
        for (int i = 0; i < right - left; i++) {
            subTail = subTail.next;
        }

        ListNode nextNode = subTail.next;
        subTail.next = null;
        prev.next = reverseLinkedList(subHead);
        subHead.next = nextNode;

        return dummy.next;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLinkedList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
