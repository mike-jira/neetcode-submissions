class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        left = 0
        right = len(matrix) - 1
        i = -1

        while left <= right:
            mid = int((left + right) / 2)

            if target == matrix[mid][0]:
                return True
            elif matrix[mid][0] < target:
                print(mid)
                if mid != len(matrix) - 1:
                    if matrix[mid + 1][0] > target:
                        i = mid
                        break
                    else:
                        left = mid + 1
                else:
                    i = mid
                    break
            elif matrix[mid][0] > target:
                right = mid - 1
        
        if i < 0:
            return False
        
        arr = matrix[i]
        l = 0
        r = len(arr) - 1

        while l <= r:
            mid = int((l + r) / 2)
                
            if arr[mid] < target:
                l = mid + 1
            elif arr[mid] > target:
                r = mid - 1
            else:
                return True
        
        return False