class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        return nums + nums
        # result = []

        # expectedLength = len(nums) * 2

        # while expectedLength > len(result):
        #     for num in nums:
        #         result.append(num)
        
        # return result