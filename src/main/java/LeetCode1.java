import org.junit.Test;

import java.util.HashMap;

public class LeetCode1 {
	public int[] twoSum(int[] nums, int target) {
		int[] rs = new int[2];

		HashMap<Integer, Integer> numMap = new HashMap<>(1024);
		for (int i=0; i<nums.length; i++){
			if (numMap.containsKey(nums[i])){
				if (nums[i]<<1 == target){
					rs[0] = numMap.get(nums[i]);
					rs[1] = i;
					return rs;
				}
				continue;
			}
			numMap.put(nums[i], i);
		}

		for (int i=0; i<nums.length; i++){
			if (numMap.containsKey(target-nums[i]) && nums[i]<<1 != target){
				rs[0] = i;
				rs[1] = numMap.get(target-nums[i]);
				break;
			}
		}
		return rs;
	}


	@Test
	public void test(){
		LeetCode1 leetCode1 = new LeetCode1();
		int[] rs = leetCode1.twoSum(new int[]{3,2,4}, 6);
		System.out.println(rs);
	}
}
