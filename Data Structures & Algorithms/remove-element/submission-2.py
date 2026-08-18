class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:

        # for index, num in enumerate(nums):
        #     if num == val:
        #         del nums[index]
        #         k += 1
        
        index = 0

        while len(nums) > index:
            if nums[index] == val:
                del nums[index]
                continue
            else:
                index += 1

        return len(nums)


        