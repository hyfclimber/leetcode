package leet;

public class CheckWords {

	public static void main(String[] args) {
		String[] test = {"helllo","AABBCC","AABBCChelllo","lll","","s", "ss"};
		int n = 6;
		String[] ans = f(2, test);
		for (String s : ans) {
			System.out.println(s);
		}
	}
	
	public static String[] f(int n, String[] words){
        String[] ans = new String[words.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = g(words[i]);
        }
        return ans;
    }
    
    public static String g(String word) {
        if (word == null || word.length() < 3) return word;
        char cur,last1,last2,after1,after2,after3 = '0';
        for (int i = 2; i < word.length(); i++) {
            last1 = word.charAt(i - 1);
            last2 = word.charAt(i - 2);
            cur = word.charAt(i);
            if (cur == last2 && cur == last1) {
                String s = removeCharAt(word, i);
                return g(s);
            }
        }
        if (word.length() < 6) return word;
        for (int i = 2; i < word.length() - 3; i++) {
            last1 = word.charAt(i - 1);
            last2 = word.charAt(i - 2);
            cur = word.charAt(i);
            after1 = word.charAt(i + 1);
            after2 = word.charAt(i + 2);
            after3 = word.charAt(i + 3);
            if (cur != last2 && after1 != after2 && (last1 == last2) && (cur == after1) && (after2 == after3)) {
                String s = removeCharAt(word, i);
                return g(s);
            }
        }
        return word;
    }
    
    public static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
   }

}
