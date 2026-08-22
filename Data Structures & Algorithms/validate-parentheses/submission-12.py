class Solution:
    def isValid(self, s: str) -> bool:
        x_map = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        stack = []

        for char in s:
            if len(stack) == 0 and char in x_map:
                return False
            elif char not in x_map:
                stack.append(char)
            elif char in x_map and x_map[char] == stack[-1]:
                stack.pop()
            else:
                stack.append(char)

        return len(stack) == 0
            

