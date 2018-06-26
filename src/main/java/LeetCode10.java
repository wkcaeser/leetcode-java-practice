import org.junit.Test;

import java.util.regex.Pattern;

/**
 * description:
 *
 * @author wkGui
 */
public class LeetCode10 {

    public boolean isMatch(String s, String p) {
        String pointReplaceStr = "[a-z]{1}";
        String starReplaceStr = "{0,}";
        String pointAndStarReplaceStr = "[a-z]{0,}";

        p = p.replace(".*", pointAndStarReplaceStr);
        p = p.replace("*", starReplaceStr);
        p = p.replace(".", pointReplaceStr);


        return Pattern.matches(p, s);
    }

    @Test
    public void test(){
        LeetCode10 leetCode10 = new LeetCode10();
        System.out.println(leetCode10.isMatch("aa", "a"));
        System.out.println(leetCode10.isMatch("aa", "a*"));
        System.out.println(leetCode10.isMatch("ab", ".*"));
        System.out.println(leetCode10.isMatch("aab", "c*a*b"));
    }
}
