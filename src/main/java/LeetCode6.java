import org.junit.Test;

public class LeetCode6 {
    public String convert(String s, int numRows) {
        if (s.length() == 0){
            return "";
        }
        if (numRows == 1){
            return s;
        }

        char[][] zMap = new char[numRows][s.length()];

        int col = 0;
        int row = 0;
        //移动方向   true表示纵向移动  false表示横向移动
        boolean direction = true;

        int pos = 0;
        while (pos < s.length()) {
            if (direction) {
                //纵向移动
                zMap[row][col] = s.charAt(pos);
                ++row;
                if (row >= numRows) {
                    //移动到最后一行后改为横向移动 切回纵向向上回退一行
                    direction = false;
                    --row;
                }
            } else {
                //横向移动
                --row;
                ++col;
                zMap[row][col] = s.charAt(pos);
                if (row <= 0) {
                    //纵向坐标到达首行后改为纵向移动 纵向想下移动一行
                    direction = true;
                    ++row;
                }
            }
            pos++;
        }
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j <= col; ++j) {
                if (zMap[i][j] != '\0') {
                    rs.append(zMap[i][j]);
                }
            }
        }
        return rs.toString();
    }

    public String convert2(String s, int numRows) {
        if (s.length() == 0){
            return "";
        }
        if (numRows == 1){
            return s;
        }

        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = new StringBuilder();

        }

        int row = 0;
        //移动方向   true表示纵向移动  false表示横向移动
        boolean direction = true;

        int pos = 0;
        while (pos < s.length()) {
            if (direction) {
                //纵向移动
                strs[row].append(s.charAt(pos));
                ++row;
                if (row >= numRows) {
                    //移动到最后一行后改为横向移动 切回纵向向上回退一行
                    direction = false;
                    --row;
                }
            } else {
                //横向移动
                --row;
                strs[row].append(s.charAt(pos));
                if (row <= 0) {
                    //纵向坐标到达首行后改为纵向移动 纵向想下移动一行
                    direction = true;
                    ++row;
                }
            }
            pos++;
        }
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            rs.append(strs[i]);
        }
        return rs.toString();
    }
    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
