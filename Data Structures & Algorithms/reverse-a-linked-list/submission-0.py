# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = head
        reverse = None;
        while current is not None:
            if reverse is None:
                reverse = ListNode(current.val, None)
            else:
                reverse = ListNode(current.val, reverse)
            current = current.next
            
        return reverse
