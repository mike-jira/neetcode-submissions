# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        stack = []
        
        while head:
            stack.append(head.val)
            head = head.next
        
        left = 0
        right = len(stack) - 1

        max = 0

        while left < right:
            sum = stack[left] + stack[right]
            if sum > max:
                max = sum
            left += 1
            right -= 1
        
        return max
            
        