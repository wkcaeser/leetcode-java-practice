import org.junit.Test;

import java.util.LinkedList;

public class LeetCode4 {
	private double getSingleArrayMidle(int[] nums2, boolean isSingle){
		if (isSingle){
			return nums2[nums2.length>>1];
		}else {
			int m = nums2[nums2.length>>1];
			int n = nums2[(nums2.length>>1) - 1];
			return (m+n)/2.0;
		}
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//获取总长度
		int sumLen = nums1.length + nums2.length;
		//判断总数是奇数还是偶数
		boolean isSingle = (sumLen&1) == 1;
		if (sumLen == 0){
			return 0;
		}
		//nums1为空
		if (nums1.length == 0){
			return getSingleArrayMidle(nums2, isSingle);
		}
		//nums2为空
		if (nums2.length == 0){
			return getSingleArrayMidle(nums1, isSingle);
		}

		LinkedList<Integer> linkedList = new LinkedList<>();
		int curPos1 = 0;
		int curPos2 = 0;
		while (linkedList.size() <= (sumLen>>1)){
			if (curPos1 >= nums1.length){
				linkedList.add(nums2[curPos2]);
				curPos2++;
				continue;
			}
			if (curPos2 >= nums2.length){
				linkedList.add(nums1[curPos1]);
				curPos1++;
				continue;
			}
			if (nums1[curPos1] > nums2[curPos2]){
				linkedList.add(nums2[curPos2]);
				curPos2++;
			}else {
				linkedList.add(nums1[curPos1]);
				curPos1++;
			}
		}
		//奇数长度
		if ((sumLen&1) == 1){
			return linkedList.getLast();
		}

		//偶数长度
		int m = linkedList.getLast();
		linkedList.removeLast();
		int n = linkedList.getLast();
		return (m+n)/2.0;
	}

	@Test
	public void test(){
		int[] num1 = new int[]{1};
		int[] num2 = new int[]{2,3,4};

		System.out.println(findMedianSortedArrays(num1, num2));
	}
}
