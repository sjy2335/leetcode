class Solution:
    def climbStairs(self, n: int) -> int:
        cache = [0]
        cache.append(1)
        cache.append(2)
        for i in range(3, n + 1):
            cache.append(cache[i - 1] + cache[i - 2])
        return cache[n]