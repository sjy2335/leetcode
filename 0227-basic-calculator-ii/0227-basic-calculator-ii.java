import java.util.*;

class Solution {
    public int calculate(String s) {
        
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                list.add(sb.toString()); // add the previously concatenated digits to list
                list.add(String.valueOf(c)); // add the operator
                sb.setLength(0);
            }
        }
        list.add(sb.toString());

        // 3 + 5 / 2
        // 3 + 2

        List<String> res1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            int lastIndex = res1.size() - 1;
            if (str.equals("*")) {
                int lastNumber = Integer.parseInt(res1.get(lastIndex));
                int nextNumber = Integer.parseInt(list.get(++i));
                res1.remove(lastIndex);
                res1.add(String.valueOf(lastNumber * nextNumber));
            }
            else if (str.equals("/")) {
                int lastNumber = Integer.parseInt(res1.get(lastIndex));
                int nextNumber = Integer.parseInt(list.get(++i));
                res1.remove(lastIndex);
                res1.add(String.valueOf((int) lastNumber / nextNumber));
            }
            else res1.add(str);
        }

        List<String> res2 = new ArrayList<>();
        for (int i = 0; i < res1.size(); i++) {
            String str = res1.get(i);
            int lastIndex = res2.size() - 1;
            if (str.equals("+")) {
                int lastNumber = Integer.parseInt(res2.get(lastIndex));
                int nextNumber = Integer.parseInt(res1.get(++i));
                res2.remove(lastIndex);
                res2.add(String.valueOf(lastNumber + nextNumber));
            }
            else if (str.equals("-")) {
                int lastNumber = Integer.parseInt(res2.get(lastIndex));
                int nextNumber = Integer.parseInt(res1.get(++i));
                res2.remove(lastIndex);
                res2.add(String.valueOf(lastNumber - nextNumber));
            }
            else res2.add(str);
        }

        return Integer.parseInt(res2.get(0));

    }
}