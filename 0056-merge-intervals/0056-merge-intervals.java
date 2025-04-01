import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (l1, l2) -> Integer.compare(l1[0], l2[0]));
        Deque<int[]> result = new ArrayDeque<>();
        for (int[] interval: intervals) {
            if (result.isEmpty() || result.peek()[1] < interval[0])
                result.push(interval);
            else if (result.peek()[1] < interval[1])
                result.peek()[1] = interval[1];
        }

        return result.stream().toArray(int[][]::new);
    }
}

// 1. intervals 순회하며 배열 채우고 출력하기 -> O(MN) = 10^8 1억 넘음
// 2. intervals 시작 기준으로 정렬하고 안겹치면 push, 겹치면 greedy하게 넓혀가기 -> 정렬 시간복잡도 O(NlogN)
// 3. 