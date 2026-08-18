class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        highest = 0
        current = 0

        for num in nums:
            if num == 0:
                current = 0
            else:
                current += 1
                if current > highest:
                    highest = current
        
        return highest