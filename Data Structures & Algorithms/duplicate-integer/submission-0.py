class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nums_set = set(nums)
        print(len(nums_set))
        return len(nums_set) != len(nums)
        