import org.junit.Test;

public class LeetCode3 {
	public int lengthOfLongestSubstring(String s) {
		if (s.trim().equals("")){
			return 0;
		}
		int answer = 1;
		int left = 0;
		int current = 0;
		for (int i=0; i<s.length(); i++){
			current = i;
			int temp;
			if ((temp = isExist(s, left, current)) >= 0){
				answer = Math.max(answer, current-left);
				left = temp+1;
			}
		}
		answer = Math.max(answer, current-left+1);
		return answer;
	}

	private int isExist(String s, int left, int right){
		for (int i=left; i<right; ++i){
			if (s.charAt(i) == s.charAt(right)){
				return i;
			}
		}
		return -1;
	}

	@Test
	public void test(){
		LeetCode3 leetCode3 = new LeetCode3();
		System.out.println(leetCode3.lengthOfLongestSubstring("qrsvbspk"));
	}
}
