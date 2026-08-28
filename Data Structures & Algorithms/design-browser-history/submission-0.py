class DoublyLinkedList:
    def __init__(self, prev, val, next):
        self.prev = prev
        self.val = val
        self.next = next

class BrowserHistory:

    def __init__(self, homepage: str):
        self.current = DoublyLinkedList(None, homepage, None)
        

    def visit(self, url: str) -> None:
        prev_node = self.current
        self.current = DoublyLinkedList(prev_node, url, None)
        prev_node.next = self.current

    def back(self, steps: int) -> str:
        current = self.current

        while steps > 0 and current.prev:

            current = current.prev
            steps -= 1

        self.current = current
        
        return current.val
        

    def forward(self, steps: int) -> str:
        current = self.current

        while steps > 0 and current.next:
            print(current.val)
            current = current.next
            steps -= 1
        
        self.current = current

        return current.val
        
        


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)