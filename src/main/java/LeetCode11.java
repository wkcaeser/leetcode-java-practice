import org.junit.Test;

public class LeetCode11 {
    public int maxArea(int[] height) {

        int lPos = 0;
        int rPos = height.length - 1;
        int area = 0;
        while (lPos < rPos) {
            int tempArea = Math.min(height[lPos], height[rPos]) * (rPos - lPos);
            area = Math.max(tempArea, area);
            if (height[lPos] < height[rPos]) {
                lPos ++;
            } else {
                rPos --;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new LeetCode11().maxArea(data));
    }
}
