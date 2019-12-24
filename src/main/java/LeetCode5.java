import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

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

    private String getChildStr(String s, int pre, int aft) {
        int len = s.length();
        while (pre >= 0 && aft < len && s.charAt(pre) == s.charAt(aft)) {
            pre--;
            aft++;
        }

        return s.substring(pre + 1, aft);
    }

    /**
     * 中心拓展法：
     * 选定一个字符，往两边拓展更新最长子串
     * 需要注意 aba  abba这两种形式的情况
     *
     * @param s 字符串
     * @return 最长回文串
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String rs = "";
        for (int i = 1; i < len; i++) {
            //判断aba情况
            String temp = getChildStr(s, i, i);
            if (temp.length() > rs.length()) {
                rs = temp;
            }
            //判断abba情况
            temp = getChildStr(s, i - 1, i);
            if (temp.length() > rs.length()) {
                rs = temp;
            }
        }
        return rs;
    }

    /**
     * Manacher算法
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome2(String s) {
        if ("".equals(s)) {
            return "";
        }
        //字符串预处理  aaa ==> $a#a#a#
        StringBuilder tempStr = new StringBuilder("$");
        for (int i = 0; i < s.length(); ++i) {
            tempStr.append(s.charAt(i)).append("#");
        }
        tempStr.append("\0");
        s = tempStr.toString();

        //用StringBuilder比较好   这里偷懒写法
//        s = Arrays.stream(s.split("")).reduce("$", (pre, next)->pre+next+"#") + "\0";

        int[] dp = new int[s.length()];

        int maxLength = 1;
        int start = 1;
        int id = 0;
        int mx = 0;

        int sLen = s.length() - 1;
        for (int i = 1; i < sLen; ++i) {
            //如果在mx（在回文串内或者刚好在边界）范围内  取dp[i] = Math.min(dp[2 * id - i], mx - i) 否则dp[i]=1
            if (i < mx) {
                dp[i] = Math.min(dp[2 * id - i], mx - i);
            } else {
                dp[i] = 1;
            }

            //刚好在边界  或者边界以外 需要往外扩张
            while (s.charAt(i - dp[i]) == s.charAt(i + dp[i])) {
                dp[i]++;
            }

            //如果mx最大值右移了  更新mx和id
            if (mx < i + dp[i]) {
                id = i;
                mx = i + dp[i];
            }

            //更新最长回文串
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                start = i;
            }
        }
        return s.substring(start - maxLength + 1, start + maxLength).replaceAll("$|#", "");
    }

    @Test
    public void test() {
        String s = "aaaa";
        System.out.println(longestPalindrome2(s));
    }
}
