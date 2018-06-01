import org.junit.Test;

public class LeetCode5 {
    /**
     * dp解法：
     * dpMap[][]用于存储回文串信息  dp[i][j]表示 s[j]到s[i]为回文串
     * 初始化： dp[i][i] = true 如果s[i]==s[i+1] 则dpMap[i+1][i]=true
     * 规则：如果s[i] == s[j] && dpMap[i-1][j+1]=true 则 dpMap[i][j] = true
     *
     * @param s 字符串
     * @return 最长回文串
     */
    public String longestPalindrome(String s) {
        //存储回文串 dpMap[i][j]=true 表示 s[j]到s[i]为回文串
        boolean dpMap[][] = new boolean[s.length()][s.length()];
        //存取最长回文串起点
        int start = 0;
        //存取最长回文串长度
        int maxLength = 1;

        //初始化dpMap  处理里单个字符和两个字符的情况
        for (int i = 0; i < s.length(); i++) {
            dpMap[i][i] = true;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                dpMap[i + 1][i] = true;
                start = i;
                maxLength = 2;
            }
        }

        //  dpMap[i-1][j+1] == true && s[i] == s[j]    ==> dpMap[i][j] = true
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < i - 1; j++) {
                if (dpMap[i - 1][j + 1] && s.charAt(i) == s.charAt(j)) {
                    dpMap[i][j] = true;
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        start = j;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    /**
     * 中心拓展法：
     *  选定一个字符，往两边拓展更新最长子串
     *  需要注意 aba  abba这两种形式的情况
     * @param s 字符串
     * @return 最长回文串
     */
    public String longestPalindrome1(String s) {
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            int pre = i - 1;
            int aft = i + 1;
            int curLength = 1;
            // aba形式回文串
            while (pre >= 0 && aft < s.length()) {
                if (s.charAt(pre) == s.charAt(aft)) {
                    curLength += 2;
                    if (curLength > maxLength) {
                        maxLength = curLength;
                        start = pre;
                    }
                    pre--;
                    aft++;
                } else {
                    break;
                }
            }
            //abba形式回文串
            if (i - 1 >= 0 && s.charAt(i) == s.charAt(i - 1)) {
                pre = i - 2;
                aft = i + 1;
                curLength = 2;
                if (curLength > maxLength) {
                    maxLength = curLength;
                    start = pre + 1;
                }
                while (pre >= 0 && aft < s.length()) {
                    if (s.charAt(pre) == s.charAt(aft)) {
                        curLength += 2;
                        if (curLength > maxLength) {
                            maxLength = curLength;
                            start = pre;
                        }
                        pre--;
                        aft++;
                    } else {
                        break;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    @Test
    public void test() {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }
}
