import org.junit.Test;

import java.util.HashMap;

public class LeetCode3 {
	public int lengthOfLongestSubstring(String s) {
		if (s.trim().equals("")){
			return 0;
		}
		int answer = 1;
		int len = 0;
		int currentStart = 0;
		int[] prevChar = new int[256];
		for (int i=0; i<prevChar.length; ++i){
			prevChar[i] = -1;
		}
		for (int i=0; i<s.length(); ++i){
			if (prevChar[s.charAt(i)] < currentStart){
				len++;
				answer = Math.max(answer, len);
			}else {
				currentStart = prevChar[s.charAt(i)] + 1;
				len = i - currentStart + 1;
			}
			prevChar[s.charAt(i)] = i;
		}
		return answer;
	}

	public int lengthOfLongestSubstring_map(String s) {
		if (s.trim().equals("")){
			return 0;
		}
		int answer = 1;
		int len = 0;
		int currentStart = 0;
		HashMap<Character, Integer> charMap = new HashMap<>(64);
		for (int i=0; i<s.length(); ++i){
			if ( !charMap.containsKey(s.charAt(i)) || charMap.get(s.charAt(i)) < currentStart){
				len++;
				answer = Math.max(answer, len);
			}else {
				currentStart = charMap.get(s.charAt(i)) + 1;
				len = i - currentStart + 1;
			}
			charMap.put(s.charAt(i), i);
		}
		return answer;
	}

	@Test
	public void test(){
		LeetCode3 leetCode3 = new LeetCode3();
		System.out.println(leetCode3.lengthOfLongestSubstring("qrsvbspk"));
	}
}
