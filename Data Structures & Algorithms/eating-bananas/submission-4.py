class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        result = right
        
        while left <= right:
            mid = (left + right) // 2

            s_eat = 0
            for pile in piles:
                time = math.ceil(pile / mid)
                s_eat += time
            
            if s_eat <= h:
                right = mid - 1
                result = mid
            else:
                left = mid + 1
                
        return result