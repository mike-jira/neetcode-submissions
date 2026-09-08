class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        ans = right

        while left <= right:
            mid = (left + right) // 2
            
            times = 0
            for pile in piles:
                time = math.ceil(pile / mid)
                times += time
            
            if times <= h:
                ans = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return ans
        