class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        ans = right

        while left <= right:
            mid = (left + right) // 2

            times = 0
            for pile in piles:
                times += math.ceil(pile / mid)
            print(times)
            print(mid)
            print('----')
            if times <= h:
                ans = mid
                right = mid -  1
            else:
                left = mid + 1
        
        return ans
