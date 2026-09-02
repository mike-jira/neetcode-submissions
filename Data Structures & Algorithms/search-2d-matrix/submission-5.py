class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        sh_left = 0
        sh_right = len(matrix) - 1
        sh_mid = -1

        while sh_left <= sh_right:
            sh_mid = int((sh_left + sh_right) / 2)
            if target == matrix[sh_mid][0]:
                return True
            elif matrix[sh_mid][0] > target:
                sh_right = sh_mid - 1
            elif matrix[sh_mid][0] < target:
                if sh_mid != len(matrix) - 1:
                    if matrix[sh_mid + 1][0] > target:
                        break
                    else:
                        sh_left = sh_mid + 1
                else:
                    break
        if (sh_mid < 0):
            return False
        
        arr = matrix[sh_mid]
        left = 0
        right = len(arr) - 1

        while left <= right:
            mid = int((left + right) / 2)
            if target > arr[mid]:
                left = mid + 1
            elif target < arr[mid]:
                right = mid - 1
            else:
                return True
        
        return False

        