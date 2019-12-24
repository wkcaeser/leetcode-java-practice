import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode12 {
    private static LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };
    StringBuilder stringBuilder = new StringBuilder();

    public String intToRoman(int num) {
        stringBuilder = new StringBuilder();
        int count;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            count = num / entry.getKey();
            num = num % entry.getKey();
            addChar(entry.getValue(), count);
        }
        return stringBuilder.toString();
    }

    public void addChar(String cha, int count) {
        while (count-- > 0) {
            stringBuilder.append(cha);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode12().intToRoman(3));
        System.out.println(new LeetCode12().intToRoman(4));
        System.out.println(new LeetCode12().intToRoman(9));
        System.out.println(new LeetCode12().intToRoman(58));
        System.out.println(new LeetCode12().intToRoman(1994));
    }
}
