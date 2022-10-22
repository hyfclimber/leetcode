package leet;

public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "aaa";
		String needle = "aaaa";
		int ans = strStr(haystack, needle);
		System.out.println(ans);

	}
	
	public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        int hN = haystack.length();
        int nN = needle.length();
        if (nN == 0) return 0;
        if (hN < nN) return -1;
        char firstNChar = needle.charAt(0);
        for (int i = 0; i < hN; i++) {
            if (haystack.charAt(i) == firstNChar) {
            	boolean isSame = true;
                for (int j = 0; j < nN; j++) {
                	if (i + j >= hN) return -1;
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                    	isSame = false;
                    	break;
                    }
                }
                if (isSame) return i;
            }
        }
        return -1;

    }

}
