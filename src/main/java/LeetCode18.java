import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return rs;
        }
        Arrays.sort(nums);
        process(nums, 0, nums.length - 1, target, 4, new LinkedList<>(), rs);
        rs.sort(this::compare);
        List<List<Integer>> rsNew = new ArrayList<>();
        if (rs.size() > 0) {
            rsNew.add(rs.get(0));
            for (int i = 1; i < rs.size(); i++) {
                if (!isSame(rs.get(i), rs.get(i - 1))) {
                    rsNew.add(rs.get(i));
                }
            }
            rs = rsNew;
        }
        return rs;
    }

    private void process(int[] nums, int stPos, int endPos, int target, int n, LinkedList<Integer> rsItem, List<List<Integer>> rs) {
        if (n == 2) {
            int curSt = stPos;
            int st = curSt;
            int end = endPos;
            while (st < end) {
                if (nums[st] + nums[end] == target) {
                    rsItem.add(nums[st]);
                    rsItem.add(nums[end]);
                    addRs(rsItem, rs);
                    rsItem.removeLast();
                    rsItem.removeLast();
                    curSt++;
                    st = curSt;
                    end = endPos;
                } else if (nums[st] + nums[end] > target) {
                    end--;
                } else {
                    st++;
                }
            }
        } else {
            while (stPos < nums.length - (n - 1)) {
                int curNum = nums[stPos];
                rsItem.add(curNum);
                process(nums, stPos + 1, endPos, target - curNum, n - 1, rsItem, rs);
                rsItem.removeLast();
                stPos++;
            }
        }
    }

    private void addRs(List<Integer> item, List<List<Integer>> rs) {
        ArrayList<Integer> itemRs = new ArrayList<>(item);
        rs.add(itemRs);
    }

    private int compare(List<Integer> l1, List<Integer> l2) {
        int n = l1.size();
        for (int i = 0; i < n; i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return Integer.compare(l1.get(i), l2.get(i));
            }
        }
        return Integer.compare(l1.get(0), l2.get(0));
    }

    private boolean isSame(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new LeetCode18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(new LeetCode18().fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }

}
