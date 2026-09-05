class ListNode:
    def __init__(self, val, prev=None, next=None):
        self.val = val
        self.next = next
        self.prev = prev

class MyStack:

    def __init__(self):
        dummy = ListNode(-1)
        self.head = dummy
        self.tail = dummy
        self.size = 0
        
    def push(self, x: int) -> None:
        new_node = ListNode(x, self.tail)

        if self.size == 0:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = self.tail.next

        self.size += 1
        
    def pop(self) -> int:
        prev_node = self.tail.prev
        current_node = self.tail

        if prev_node:
            prev_node.next = None

        current_node.prev = None

        self.tail = prev_node

        self.size -= 1

        return current_node.val
        
    def top(self) -> int:
        return self.tail.val
        
    def empty(self) -> bool:
        return self.size == 0
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()