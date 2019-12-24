import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode17 {
    private HashMap<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return new ArrayList<>();
        }
        digits = digits.replace("1", "");
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> rs = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        process(digits, 0, stringBuilder, rs);
        return rs;
    }

    private void process(String digits, int currentPos, StringBuilder currentStr, List<String> rs) {
        if (currentPos == digits.length()) {
            rs.add(currentStr.toString());
            return;
        }
        String num = digits.charAt(currentPos) + "";
        String str = map.get(num);
        for (int i = 0; i < str.length(); i++) {
            currentStr.append(str.charAt(i));
            process(digits, currentPos + 1, currentStr, rs);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode17().letterCombinations("23"));
    }
}
