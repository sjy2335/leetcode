import java.util.*;

class Solution {

    private class Histogram {
        int height, index;

        Histogram(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Histogram> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (!stack.isEmpty() && stack.peek().height >= heights[i]) {
                while (stack.peek().height >= heights[i]) {
                    Histogram top = stack.pop();
                    if (stack.isEmpty()) {
                        result = Math.max(result, top.height * i);
                        break;
                    } else
                        result = Math.max(result, top.height * (i - stack.peek().index - 1));
                }
            }
            stack.push(new Histogram(heights[i], i));
        }

        while (!stack.isEmpty()) {
            Histogram top = stack.pop();
            if (stack.isEmpty()) result = Math.max(result, top.height * heights.length);
            else result = Math.max(result, top.height * (heights.length - stack.peek().index - 1));
        }

        return result;
    }
}
