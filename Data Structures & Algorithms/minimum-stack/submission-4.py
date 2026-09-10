class MinStack:

    def __init__(self):
        self.stack = []
        self.minTrack = []
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.minTrack:
            if self.minTrack[-1] > val:
                self.minTrack.append(val)
            else:
                self.minTrack.append(self.minTrack[-1])
        else:
            self.minTrack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minTrack.pop()
        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.minTrack[-1]
        
