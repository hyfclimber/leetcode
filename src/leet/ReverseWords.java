package leet;

//557. 反转字符串中的单词 III
//给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//例子1：
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//2：
//输入： s = "God Ding"
//输出："doG gniD"

//提示：
//1 <= s.length <= 5 * 104
//s 包含可打印的 ASCII 字符。
//s 不包含任何开头或结尾空格。
//s 里 至少 有一个词。
//s 中的所有单词都用一个空格隔开。

public class ReverseWords {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
//		String s = null;
		System.out.println(reverseWords(s));
	}
	
	/**
	 * 1、按空格进行分割，不用系统方法，就一个个的取。用两个指针来控制每一个单词。
	 * 2、取到每一个子串后，进行子串翻转。
	 * 3、拼接
	 */
	public static String reverseWords(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int l = 0;
		int r = 0;
		int N = s.length();
		String ans = "";
		while (l < N && r < N) {
			
			while (l < N && r < N && s.charAt(r) != ' ') {
				r++;
			}
			String sub = s.substring(l, r);
			ans += reverseStr(sub);
			if (r < N) {
				ans += " ";
			} 
			if (r + 1 < N) {
				r = r + 1;
				l = r;
			}
		}
		
		return ans;
    }
	
	public static String reverseStr(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		char[] chs = s.toCharArray();
		int left = 0;
		int right = chs.length - 1;
		while (left <= right) {
			char tmp = chs[left];
			chs[left] = chs[right];
			chs[right] = tmp;
			left++;
			right--;
		}
		String ans = new String(chs);
		return ans;
	}
	

}
