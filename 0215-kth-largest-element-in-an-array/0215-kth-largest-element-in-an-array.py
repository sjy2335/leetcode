import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq = []
        for num in nums:
            heappush(pq, -num)
        for i in range(k - 1):
            heappop(pq)
        return -heappop(pq)