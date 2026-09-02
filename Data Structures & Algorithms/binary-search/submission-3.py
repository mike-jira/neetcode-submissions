class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def binarySearch(arr: List[int], left: int, right: int):
            mid = int((left + right) / 2)

            if left > right:
                return - 1
            
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                return binarySearch(arr, mid + 1, right)
            else:
                return binarySearch(arr, left, mid - 1)
        
        left = 0
        right = len(nums) - 1
        return binarySearch(nums, left, right)
            