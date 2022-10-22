package leet;

public class Palind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "  ";
		boolean ans = isPalindrome(s);
        System.out.println(ans);
	}

	
	public static boolean isPalindrome(String s) {
        String lowerS = s.toLowerCase();
        String regex = "[^a-z\\d]+";
		lowerS = lowerS.replaceAll(regex, "");
        int N = lowerS.length();
        for (int i = 0; i < N / 2; i++) {
            if (lowerS.charAt(i) != lowerS.charAt(N - 1 - i)) return false;
        }
        return true;
    }
}
