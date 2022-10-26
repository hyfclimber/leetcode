package leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindrome409 {

	public static void main(String[] args) {
		String s = "aaccvACCCCCC";
		int ans = longestPalindrome(s);
		System.out.println(ans);

	}

	public static int longestPalindrome(String s) {
		int ans = 0;
		Map<Character, Integer> cache = new HashMap<Character, Integer>();
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			cache.put(chs[i], cache.getOrDefault(chs[i], 0) + 1);
		}
		boolean hasOdd = false;
		for (Entry<Character, Integer> e : cache.entrySet()) {
			int value = (Integer)e.getValue();
			int v = value % 2; 
			if (v == 1) {
				hasOdd = true;
			}
			ans += (v == 1) ? value - 1 : value;
		}
		if (hasOdd) {
			ans += 1;
		}
		return ans;

    }
}
