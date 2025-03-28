import java.util.*;

class Solution {

    private Deque<Integer> stack;

    public String minRemoveToMakeValid(String s) {
        
        stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLowAlphabet(c)) sb.append(c);

            if (c == '(') {
                sb.append(c);
                stack.push(sb.length() - 1);
            }

            if (c == ')') {
                if (stack.isEmpty()) continue;
                stack.pop();
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }

    private boolean isLowAlphabet(char c) {
        return c >= 'a' && c <= 'z';
    }
}