class MinStack:

    def __init__(self):
        self.value = []
        self.stack = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.value) > 0:
            min_val = self.value[-1]
            if min_val > val:
                self.value.append(val)
            else:
                self.value.append(min_val)
        else:
            self.value.append(val)
        

    def pop(self) -> None:
        self.stack.pop()
        self.value.pop()

    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.value[-1]
        
