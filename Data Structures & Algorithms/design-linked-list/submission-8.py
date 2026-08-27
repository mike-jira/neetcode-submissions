class DoublyLinkedList:
    def __init__(self, prev, val, next):
        self.prev = prev
        self.val = val
        self.next = next

class MyLinkedList:

    def __init__(self):
        self.size = 0
        self.head = None
        self.tail = self.head
        
    def get(self, index: int) -> int:
        if self.size <= index:
            return -1
        
        current = self.head
        for _ in range(index):
            current = current.next
        
        return current.val
        

    def addAtHead(self, val: int) -> None:
        new_node = DoublyLinkedList(None, val, self.head)

        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.head.prev = new_node
            self.head = new_node
        
        self.size += 1
            
    def addAtTail(self, val: int) -> None:
        new_node = DoublyLinkedList(self.tail, val, None)

        if self.tail is None:
            self.tail = new_node
            self.head = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node

        self.size += 1
        

    def addAtIndex(self, index: int, val: int) -> None:
        if self.size < index:
            return

        if index == self.size:
           self.addAtTail(val)
           return
        
        if index == 0:
            self.addAtHead(val)
            return
        
        current = self.head
        for _ in range(index):
            current = current.next
        
        prev_node = current.prev
        new_node = DoublyLinkedList(prev_node, val, current)
        prev_node.next = new_node
        current.prev = new_node

        self.size += 1

        

    def deleteAtIndex(self, index: int) -> None:
        if self.size <= index:
            return -1

        # case 1 remove head
        if index == 0:
            self.head = self.head.next
            self.head.prev = None

        # case 2 remove tail
        elif index == self.size - 1:
            self.tail = self.tail.prev
            self.tail.next = None
        else:
            current = self.head
            for i in range(index):
                current = current.next
            # case 3 remove middle (normal case)
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