import java.util.*;

class Solution {

    public int subarraySum(int[] nums, int k) {

        // brute-force would be O(N^3) from N * N * (N + 1) / 2
        // for iterating 1 ~ N sized arrays in each elements

        // calculating the sum is duplicated work, remove it by prefixSumArray
        // iterating for finding the complement is duplicated work -> remove it by HashTable

        // constructing prefixSumArray O(N), constructing HashTable O(N), 
        // iterating the array O(N), accessing HashTable O(1)
        // Therefore, O(N)

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 누적 합이 k인 경우를 위해 기본 값 설정
        
        int sum = 0, result = 0;
        for (int num : nums) {
            sum += num; // 현재까지의 누적 합
            
            // (sum - k) 가 이전에 존재하면 그 개수만큼 subarray 존재
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            
            // 현재 sum을 map에 추가
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}