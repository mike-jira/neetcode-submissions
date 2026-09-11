class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        u = 0

        for i in range(0, len(nums)):
            if nums[u] != nums[i]:
                u += 1
                nums[u] = nums[i]

        return u + 1

            