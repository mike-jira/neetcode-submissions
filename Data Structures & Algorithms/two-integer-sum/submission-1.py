from collections import defaultdict

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sum_map = defaultdict(int)

        for index, num in enumerate(nums):
            find = target - num

            if num in sum_map:
                return [sum_map[num], index]
            
            sum_map[find] = index