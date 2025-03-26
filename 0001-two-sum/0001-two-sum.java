import java.util.*;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int length = nums.length;
		for (int i = 0; i < length; i++) {
            List tmp = map.getOrDefault(nums[i], new ArrayList<>());
            tmp.add(i);
            map.put(nums[i], tmp);
		}

		for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
			int opposite = target - entry.getKey();
            
            if (opposite == entry.getKey() && entry.getValue().size() > 1)
                return new int[] {entry.getValue().get(0), entry.getValue().get(1)};

			else if (map.containsKey(opposite))
				return new int[] {entry.getValue().get(0), map.get(opposite).get(0)};
		}

		return new int[] {-1, -1};
	}
}
