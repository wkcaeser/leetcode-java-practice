import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode16 {
    private boolean rsInit = false;
    public int threeSumClosest(int[] nums, int target) {
        int rs = 0;
        if (nums.length < 3) {
            for (int m : nums) {
                rs += m;
            }
            return rs;
        }
        rsInit = false;
        Arrays.sort(nums);
        int lPos = 0;
        int rPos = nums.length - 1;
        int tMid = lPos + 1;
        while (lPos < rPos - 1) {
            if (tMid >= rPos) {
                lPos++;
                rPos = nums.length - 1;
                tMid = lPos + 1;
                continue;
            }
            if (nums[lPos] + nums[rPos] + nums[tMid] == target) {
                return target;
            }
            if (nums[lPos] + nums[rPos] + nums[tMid] > target) {
                rs = setRs(nums[lPos] + nums[rPos] + nums[tMid], target, rs);
                rPos--;
            }
            if (nums[lPos] + nums[rPos] + nums[tMid] < target) {
                rs = setRs(nums[lPos] + nums[rPos] + nums[tMid], target, rs);
                tMid++;
            }
        }
        return rs;
    }

    private int setRs(int newRs, int target, int rs) {
        if (!rsInit) {
            rsInit = true;
            return newRs;
        }
        if (Math.abs(newRs - target) < Math.abs(rs - target)) {
            return newRs;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode16().threeSumClosest(new int[]{-1, 1, 2, -4}, 1));
    }
}
