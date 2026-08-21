class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for char in s:
            if char == '[' or char == '{' or char == '(':
                stack.append(char)
            else:
                if len(stack) > 0:
                    if (stack[-1] == '[' and char == ']') or (stack[-1] == '{' and char == '}') or (stack[-1] == '(' and char == ')'):
                        stack.pop()
                    else:
                        stack.append(char)
                else:
                    stack.append(char)
        return len(stack) == 0

                    

        