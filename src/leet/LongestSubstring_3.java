package leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstring_3 {

	public static void main(String[] args) {
		String test = "abcabcbb";
		int ans = lengthOfLongestSubstring1(test);
		System.out.println(ans);
	
	}
	
	//每次遇到重复的，就回退到重复元素的下一个index，这个算法效率很低，最差可到o(n^2)
	public static int lengthOfLongestSubstring(String s) {
        int N = s.length();
        if (N == 0 || N == 1) return N;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int p1 = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                max = Math.max(max, i - p1);
                p1 = map.get(c) + 1;
                map.clear();
                i = p1 - 1; //下句还会执行i++
            } else {
                map.put(c, i);
            }
        }
        if (p1 < N) max = Math.max(max, N - p1);
        return max;
    }
	public static int lengthOfLongestSubstring1(String s) {
		int N = s.length();
		if (N == 0 || N == 1) return N;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Queue<Character> queue = new LinkedList<Character>();
		int max = 0;
		for (int i = 0; i < N; i++) {
			System.out.println(queue);
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				max = Math.max(max, queue.size());
				while(!queue.isEmpty()) {
					Character ch = queue.poll();
					map.remove(ch);
					if (ch == c) break;
				}
				map.put(c, i);
				queue.offer(c);
			} else {
				map.put(c, i);
				queue.offer(c);
			}
		}
		if (!queue.isEmpty()) max = Math.max(max, queue.size());
		return max;
	}

}
