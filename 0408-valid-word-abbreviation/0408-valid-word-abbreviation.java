class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder digit = new StringBuilder();
        int cursor = 0; // word의 다음 index
        for (int i = 0; i < abbr.length(); i++) { // i는 abbr의 다음 index
            char c = abbr.charAt(i);

            if (Character.isDigit(c)) {
                if (digit.length() == 0 && c == '0') return false;
                digit.append(c);
            }

            // substitution
            // s 10 n
            else {
                if (digit.length() > 0) {
                    int parsed = Integer.parseInt(digit.toString());
                    digit = new StringBuilder();
                    cursor += parsed;
                }

                if (cursor >= word.length() || c != word.charAt(cursor++)) return false;
            }
        }

        if (digit.length() > 0) cursor += Integer.parseInt(digit.toString());
        if (cursor != word.length()) return false;

        return true;
    }
}