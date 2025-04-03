class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] cache = new boolean[N][N];
        int start = 0, end = 0;

        for (int i = 0; i < N; i++) {
            cache[i][i] = true;
        }

        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cache[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }

        for (int length = 3; length <= N; length++) {
            for (int left = 0; left <= N - length; left++) {
                int right = left + length - 1;
                if (cache[left + 1][right - 1] && s.charAt(left) == s.charAt(right)) {
                    cache[left][right] = true;
                    start = left;
                    end = right;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}