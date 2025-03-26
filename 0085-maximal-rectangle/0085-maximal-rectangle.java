import java.util.*;

class Solution {
    private int R, C;

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        R = matrix.length;
        C = matrix[0].length;
        int[][] sumMatrix = new int[R][C];

        // Prefix sum 계산 (각 열에 대해 연속된 1의 개수 누적)
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == '1') {
                    sumMatrix[i][j] = (i == 0) ? 1 : sumMatrix[i - 1][j] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            result = Math.max(result, maxRectangleForRow(sumMatrix[i]));
        }

        return result;
    }

    private int maxRectangleForRow(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int[] extended = Arrays.copyOf(heights, heights.length + 1); // 마지막에 0 추가해 계산 편리하게
        
        for (int i = 0; i < extended.length; i++) {
            while (!stack.isEmpty() && extended[stack.peek()] > extended[i]) {
                int height = extended[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}