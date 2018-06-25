import org.junit.Test;

/**
 * description:
 *
 * @author wkGui
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        int original = x;

        int y = 0;

        int mod = 10;

        while (x / mod > 0){
            y = y*10 + x%mod;
            x = x / mod;
        }

        y = y*10 + x;

        return original == y;
    }

    public boolean isX(int x){
        return new StringBuilder(x+"").reverse().toString().equals(x+"");
    }

    @Test
    public void test(){

        LeetCode9 leetCode9 = new LeetCode9();
        System.out.println(leetCode9.isPalindrome(121));

        System.out.println(leetCode9.isX(121));
    }
}
