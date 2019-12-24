import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if (nums.length < 3) {
            return rs;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return rs;
        }
        if (nums[nums.length - 1] < 0) {
            return rs;
        }
        if (nums[0] == 0 && nums[2] == 0) {
            rs.add(new ArrayList<Integer>() {{
                add(0);
                add(0);
                add(0);
            }});
            return rs;
        }
        if (nums[nums.length - 1] == 0 && nums[nums.length - 3] == 0) {
            rs.add(new ArrayList<Integer>() {{
                add(0);
                add(0);
                add(0);
            }});
            return rs;
        }
        int lPos = 0;
        int rPos = nums.length - 1;
        int mid = findMidPos(nums);
        int tMid = lPos + 1;
        while (lPos < rPos - 1 && lPos <= mid) {
            if (tMid >= rPos) {
                lPos++;
                rPos = nums.length - 1;
                tMid = lPos + 1;
                continue;
            }
            if (nums[lPos] + nums[rPos] + nums[tMid] == 0) {
                ArrayList<Integer> rsNode = new ArrayList<>();
                rsNode.add(nums[lPos]);
                rsNode.add(nums[tMid]);
                rsNode.add(nums[rPos]);
                rs.add(rsNode);
                rPos --;
                tMid = lPos + 1;
                continue;
            }
            if (nums[lPos] + nums[rPos] + nums[tMid] > 0) {
                rPos--;
            }
            if (nums[lPos] + nums[rPos] + nums[tMid] < 0) {
                tMid++;
            }
        }
        List<List<Integer>> finalRs = new ArrayList<>();
        if (rs.size() > 0) {
            rs.sort((l1, l2) -> {
                if (l1.get(0).equals(l2.get(0))) {
                    if (l1.get(1).equals(l2.get(1))) {
                        return Integer.compare(l1.get(2), l2.get(2));
                    } else {
                        return Integer.compare(l1.get(1), l2.get(1));
                    }
                } else {
                    return Integer.compare(l1.get(0), l2.get(0));
                }
            });
            for (int i = 0; i < rs.size(); i++) {
                int j = i + 1;
                while (j < rs.size() && isSame(rs.get(i), rs.get(j))) {
                    j++;
                }
                finalRs.add(rs.get(i));
                i = j - 1;
            }
            return finalRs;
        } else {
            return rs;
        }
    }

    private boolean isSame(List<Integer> l1, List<Integer> l2) {
        return l1.get(0).equals(l2.get(0)) && l1.get(1).equals(l2.get(1)) && l1.get(2).equals(l2.get(2));
    }

    private int findMidPos(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i;
            }
            if (nums[i] > 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
