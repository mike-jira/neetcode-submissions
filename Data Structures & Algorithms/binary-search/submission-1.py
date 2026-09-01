class Solution:
    def search(self, nums: List[int], target: int) -> int:
        min = 0
        max = len(nums) - 1

        while min <= max:
            mid = int((max + min) / 2)

            if target > nums[mid]:
                min = mid + 1
            elif target < nums[mid]:
                max = mid - 1
            else:
                return mid
        
        return -1

