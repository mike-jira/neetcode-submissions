# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        seen = {}

        while head:
            if head.next:
                if head.next in seen:
                    return True
                seen[head] = True

            head = head.next

        return False
        