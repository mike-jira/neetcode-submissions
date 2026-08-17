from collections import defaultdict 

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        table_s = defaultdict(int)
        table_t = defaultdict(int)

        for i in range(len(s)):
            table_s[s[i]] += 1
            table_t[t[i]] += 1
        
        return table_s == table_t