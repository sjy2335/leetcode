import heapq

class Solution:
    def maxPotholes(self, road: str, budget: int) -> int:
        heap = []
        result = 0
        i = 0

        while i < len(road):
            potholes = 0
            while i < len(road) and road[i] == 'x':
                potholes += 1
                i += 1
            if potholes != 0:
                heapq.heappush(heap, -potholes)
            i += 1

        while budget > 0 and heap:
            curr = -heapq.heappop(heap)
            budget -= curr + 1
            result += curr
            if budget < 0:
                result -= -budget

        return result