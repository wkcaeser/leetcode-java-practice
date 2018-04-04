import org.junit.Test;

import java.math.BigInteger;

public class LeetCode2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigInteger num1 = BigInteger.valueOf(0);
		BigInteger multiple1 = BigInteger.valueOf(1);
		while (l1 != null){
			num1 = num1.add(multiple1.multiply(BigInteger.valueOf(l1.val)));
			multiple1 = multiple1.multiply(BigInteger.valueOf(10));
			l1 = l1.next;
		}

		BigInteger num2 = BigInteger.valueOf(0);
		BigInteger multiple2 = BigInteger.valueOf(1);
		while (l2 != null){
			num2 = num2.add(multiple2.multiply(BigInteger.valueOf(l2.val)));
			multiple2 = multiple2.multiply(BigInteger.valueOf(10));
			l2 = l2.next;
		}
		BigInteger sum = num1.add(num2);

		ListNode rs;
		if (sum.compareTo(BigInteger.valueOf(0)) == 0){
			rs = new ListNode(0);
		}else {
			rs = new ListNode(sum.mod(BigInteger.valueOf(10)).intValue());
			sum = sum.divide(BigInteger.valueOf(10));
		}

		ListNode current = rs;
		while (sum.compareTo(BigInteger.valueOf(0)) != 0){
			ListNode tmp = new ListNode(sum.mod(BigInteger.valueOf(10)).intValue());
			current.next = tmp;
			current = tmp;
			sum = sum.divide(BigInteger.valueOf(10));
		}

		while (rs != null){
			System.out.print(rs.val + " -> ");
			rs = rs.next;
		}
		return rs;
	}

	 // Definition for singly-linked list.
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }

	 @Test
	public void test(){
		ListNode l1_1 = new ListNode(9);

		 ListNode l2_3 = new ListNode(9);
		 ListNode l2_2 = new ListNode(9);
		 l2_2.next = l2_3;
		 ListNode l2_1 = new ListNode(9);
		 l2_1.next = l2_2;
		 ListNode l2_4 = new ListNode(9);
		 l2_4.next = l2_1;
		 ListNode l2_5 = new ListNode(9);
		 l2_5.next = l2_4;
		 ListNode l2_6 = new ListNode(1);
		 l2_6.next = l2_5;

		 LeetCode2 leetCode2 = new LeetCode2();
		 leetCode2.addTwoNumbers(l1_1, l2_6);
	 }
}
