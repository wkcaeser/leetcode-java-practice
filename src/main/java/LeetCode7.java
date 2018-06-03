public class LeetCode7 {
    public int reverse(int x) {
        String num = Integer.toString(x);
        if (x < 0) {
            num = num.substring(1, num.length());
        }
        int rs;

        try {
            rs = Integer.valueOf(new StringBuilder(num).reverse().toString());
        } catch (NumberFormatException e) {
            rs = 0;
        }

        if (x < 0) {
            return -rs;
        }
        return rs;
    }
}
