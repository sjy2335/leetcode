import java.util.*;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int N = height.length;
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];
        
        leftMax[0] = height[0];
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[N - 1] = height[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return answer;
    }
}