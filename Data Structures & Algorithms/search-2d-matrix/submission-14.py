class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        left = 0
        col_len = len(matrix[0])
        right = col_len * len(matrix) - 1

        while left <= right:
            mid = (left + right) // 2

            row = mid // col_len
            col = mid - (row * col_len)

            print(row)
            print(col)
            print('-----')

            val = matrix[row][col]

            print(val)
            print('0000')

            if target > val:
                left = mid + 1
            elif target < val:
                right = mid - 1
            else:
                return True

        return False
        