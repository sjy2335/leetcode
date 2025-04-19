from collections import deque

class Solution:

    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        generating all possible substrings? -> 5 * 10^4 C 2 -> 10 ^ 9 = 10억인데..
        deque에 한 글자씩 넣으면서 set에 글자 넣기.
        이미 존재하는 글자 한번더 나오면, 그 글자 없어질 때까지 pop하기
        """
        dq = deque()
        appeared = set()
        answer = 0
        
        for c in s:

            while dq and c in appeared:
                polled = dq.popleft()
                appeared.remove(polled)
                if polled == c:
                    break

            dq.append(c)
            appeared.add(c)
            answer = max(answer, len(dq))
            
        return answer
