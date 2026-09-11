class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        s = 0
        f = 1

        while f <= len(nums) - 1:
            if nums[s] != nums[f]:
                s += 1
                f += 1
            else:
                nums.pop(f)
        
        return len(nums)

            
