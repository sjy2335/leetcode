import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && isParenthesesMatching(stack.peek(), c)) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty();
    }

    private boolean isOpeningParentheses(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isParenthesesMatching(char c, char d) {
        if (c == '(' && d == ')') return true;
        if (c == '{' && d == '}') return true;
        if (c == '[' && d == ']') return true;
        return false;
    }
}