class DoublyLinkedList:
    def __init__(self, val, prev=None, next=None):
        self.prev = prev
        self.val = val
        self.next = next

class MyLinkedList:

    def __init__(self):
        self.size = 0
        self.head = None
        self.tail = None
        

    def get(self, index: int) -> int:
        if index >= self.size:
            return -1
        
        current = self.head

        for _ in range(index):
            current = current.next
        
        return current.val
        

    def addAtHead(self, val: int) -> None:
        new_node = DoublyLinkedList(val, None, self.head)

        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.head.prev = new_node
            self.head = new_node
        
        self.size += 1
        

    def addAtTail(self, val: int) -> None:
        new_node = DoublyLinkedList(val, self.tail, None)

        if self.tail is None:
            self.tail = new_node
            self.head = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        
        self.size += 1
        

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self.size:
            return

        if self.size == index:
            self.addAtTail(val)
            return

        if index == 0:
            self.addAtHead(val)
            return

        current = self.head

        for _ in range(index):
            current = current.next

        prev_node = current.prev
        
        new_node = DoublyLinkedList(val, prev_node, current)

        prev_node.next = new_node
        current.prev = new_node

        self.size += 1

    def deleteAtIndex(self, index: int) -> None:
        if index >= self.size:
            return

        current = self.head

        for _ in range(index):
            current = current.next
        
        if current == self.head:
            self.head = current.next
            self.head.prev = None
        elif current == self.tail:
            self.tail = current.prev
            self.tail.next = None
        elif self.size == 1:
            self.head = None
            self.tail = None
        else:
            prev_node = current.prev
            next_node = current.next

            prev_node.next = next_node
            next_node.prev = prev_node
        

        self.size -= 1
        
# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)