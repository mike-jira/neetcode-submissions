class DoublyLinkedList:
    def __init__(self, prev, val, next):
        self.prev = prev
        self.val = val
        self.next = next


class MyLinkedList:

    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def get(self, index: int) -> int:
        # index ต้องอยู่ในช่วง 0 ถึง size - 1
        if index < 0 or index >= self.size:
            return -1

        # เดินจาก head
        current = self.head

        for _ in range(index):
            current = current.next

        return current.val

    def addAtHead(self, val: int) -> None:
        new_node = DoublyLinkedList(None, val, self.head)

        if self.head is None:
            # empty list
            self.head = new_node
            self.tail = new_node
        else:
            self.head.prev = new_node
            self.head = new_node

        self.size += 1

    def addAtTail(self, val: int) -> None:
        new_node = DoublyLinkedList(self.tail, val, None)

        if self.tail is None:
            # empty list
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node

        self.size += 1

    def addAtIndex(self, index: int, val: int) -> None:
        # ตามโจทย์:
        # index < 0 ไม่ valid
        # index > size ไม่ทำอะไร
        # index == size = addAtTail
        # index == 0 = addAtHead

        if index < 0 or index > self.size:
            return

        if index == 0:
            self.addAtHead(val)
            return

        if index == self.size:
            self.addAtTail(val)
            return

        # หา node ที่อยู่ตำแหน่ง index
        current = self.head

        for _ in range(index):
            current = current.next

        prev_node = current.prev

        new_node = DoublyLinkedList(
            prev_node,
            val,
            current
        )

        prev_node.next = new_node
        current.prev = new_node

        self.size += 1

    def deleteAtIndex(self, index: int) -> None:
        # index ต้องอยู่ในช่วง 0 ถึง size - 1
        if index < 0 or index >= self.size:
            return

        current = self.head

        for _ in range(index):
            current = current.next

        # ลบ node เดียว
        if self.size == 1:
            self.head = None
            self.tail = None

        # ลบ head
        elif current == self.head:
            self.head = current.next
            self.head.prev = None

        # ลบ tail
        elif current == self.tail:
            self.tail = current.prev
            self.tail.next = None

        # ลบตรงกลาง
        else:
            prev_node = current.prev
            next_node = current.next

            prev_node.next = next_node
            next_node.prev = prev_node

        self.size -= 1