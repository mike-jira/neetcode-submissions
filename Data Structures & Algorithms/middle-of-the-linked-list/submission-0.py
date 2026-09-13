# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = head
        fast = head

        n = 0

        while fast:
            fast = fast.next
            n += 1
        
        print(slow.val)

        mid = n // 2

        for _ in range(mid):
            slow = slow.next

        return slow