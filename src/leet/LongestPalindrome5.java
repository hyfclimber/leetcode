package leet;

public class LongestPalindrome5 {

	public static void main(String[] args) {
		String s = "abbbbbbbbbba";
		long start = System.nanoTime();
		System.out.println(longestPalindrome2(s));
		long end = System.nanoTime();
		System.out.println("耗时： " + (end - start) / 1000 + "微秒");
	}
	
	public static String longestPalindrome2(String s) {
        int N = s.length();
        String ans = s.substring(0,1);
        int maxLen = 1;
        for (int i = 0; i < N; i++) {
            String odd = helper(i, i, s, maxLen);
            if (odd.length() > maxLen) {
            	ans = odd;
            	maxLen = odd.length();
            }
            String even = helper(i, i+1, s, maxLen);
            if (even.length() > maxLen) {
            	ans = even;
            	maxLen = even.length();
            }
        }
        return ans;
    }
	
	public static String helper(int l, int r, String s, int max) {
		String ans = "";
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		if (r - 1 - (l + 1) + 1 > max) {
			ans = s.substring(l + 1, r);
		}
		return ans;
	}
	
	public static String longestPalindrome(String s) {
        int N = s.length();
        String ans = s.substring(0,1);
        for (int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if ((j - i + 1) > ans.length() && isPalindrome1(s, i, j)) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    public static boolean isPalindrome1(String s, int left, int right) {
        if (left > right) return false;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}
