import java.util.*;

class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, false);
    }
    private boolean validPalindrome(String s, int l, int r, boolean deleted) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (deleted) return false;
                return validPalindrome(s, l + 1, r, true) || validPalindrome(s, l, r - 1, true);
            }
            l++;
            r--;
        }
        return true;
    }
}