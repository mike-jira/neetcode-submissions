class Solution:
    def calPoints(self, operations: List[str]) -> int:
        result = []
        for index, operation in enumerate(operations):
            if operation == '+':
                result.append(result[len(result) - 1] + result[len(result) - 2])
            elif operation == 'C':
                result.pop()
            elif operation == 'D':
                result.append(result[len(result) - 1] * 2)
            else:
                result.append(int(operation))
        print(result)
        return sum(result)