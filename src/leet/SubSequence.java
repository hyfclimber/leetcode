package leet;

public class SubSequence {

	public static void main(String[] args) {

		String s = "abc";
		String t = "ahbgdc";
		boolean ans = isSubsequence(s, t);
		System.out.println(ans);
	}

	public static boolean isSubsequence(String s, String t) {
        int sIdx = 0, tIdx = 0;
        while (sIdx < s.length() && tIdx < t.length()) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
            tIdx++;
        }
        return sIdx == s.length();
    }
}
