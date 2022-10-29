package leet;

import java.util.HashMap;
import java.util.Map;

//面试题 01.02. 判定是否互为字符重排
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//输入: s1 = "abc", s2 = "bca"
//输出: true 
//输入: s1 = "abc", s2 = "bad"
//输出: false
//
//0 <= len(s1) <= 100
//0 <= len(s2) <= 100
public class CheckPermutation {

	public static void main(String[] args) {
		String s1 = "abc", s2 = "bac";
		boolean ans = CheckPermutation(s1, s2);
		System.out.println(ans);
	}
	
	public static boolean CheckPermutation(String s1, String s2) {
        int N1 = s1.length();
        int N2 = s2.length();
        if (N1 != N2) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < N1; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < N2; i++) {
            char c = s2.charAt(i);
            int times = map.getOrDefault(c, 0);
            if (times == 0) return false;
            if (times == 1) {
            	map.remove(c);
            } else {
            	 map.put(c, times - 1);
            }
        }
        System.out.println(map);
        if (!map.isEmpty()) {
            return false;
        }

        return true;
    }

}
