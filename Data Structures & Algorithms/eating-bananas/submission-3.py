class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        ans = right
        while left <= right:
            mid = (left + right) // 2

            if self.eat(mid, piles) <= h:
                ans = mid
                # although we already find a solution, continue search for a optimal solution
                right = mid -1
            else:
                left = mid + 1
        
        return ans

    def eat(self, val: int, piles: List[int]):
        sum = 0
        for pile in piles:
            time = math.ceil(pile / val)
            sum += time
        return sum
