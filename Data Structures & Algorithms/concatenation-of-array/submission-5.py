class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        result = []

        expectedLength = len(nums) * 2

        while expectedLength > len(result):
            for num in nums:
                result.append(num)
        
        return result
        # alternate result return nums + nums