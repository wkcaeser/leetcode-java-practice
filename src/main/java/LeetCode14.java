public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean same = true;
            for (int j=1; j<strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    same = false;
                    break;
                }
            }
            if (same) {
                builder.append(c);
            } else {
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
