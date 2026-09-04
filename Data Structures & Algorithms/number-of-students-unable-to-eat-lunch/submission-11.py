class LinkedList:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

class Queue:
    def __init__(self, vals: List[int]):
        dummy = LinkedList(-1)
        self.head = dummy
        self.tail = dummy
        self.size = 0

        for val in vals:
            node = LinkedList(val)
            self.tail.next = node
            self.tail = self.tail.next
            self.size += 1
        
        self.head = self.head.next
            
    def enqueue(self, val):
        new_node = LinkedList(val)
        self.tail.next = new_node
        self.tail = self.tail.next
        self.size += 1
        
    def dequeue(self):
        next_node = self.head.next
        self.head.next = None
        self.head = next_node
        self.size -= 1
    
    def current(self):
        if self.head:
            return self.head.val
        return -1

class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        sq = Queue(students)
        count = 0

        while count < sq.size:
            if sandwiches[0] == sq.current():
                sandwiches.pop(0)
                sq.dequeue()
                count = 0
            else:
                current = sq.current()
                sq.dequeue()
                sq.enqueue(current)
                count += 1
        
        return sq.size











        