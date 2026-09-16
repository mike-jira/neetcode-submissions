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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carryOver = 0;

        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if (carryOver > 0) {
                sum = sum + carryOver;
                carryOver = 0;
            }

            if (sum > 9) {
                carryOver += 1;
                sum = sum - 10;
            }

            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carryOver > 0) {
            current.next = new ListNode(carryOver);
        }

        return dummy.next;
    }
}
