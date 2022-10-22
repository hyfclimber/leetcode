package leet;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
	}
	
	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) return false;
        String sSymbol = getSymbolString(s);
        System.out.println(sSymbol);
        String tSymbol = getSymbolString(t);
        System.out.println(tSymbol);
        return sSymbol.equals(tSymbol);

    }

    public static String getSymbolString(String s) {
        Map <Character, String> sMap = new HashMap<>();
        StringBuilder ssb = new StringBuilder();
        int symbol = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            String value = sMap.getOrDefault(ch, "-1");
            if (value.equals("-1")) {
                sMap.put(ch, "_" + symbol++);
            }
            ssb.append(sMap.getOrDefault(ch, "-1"));
        }
        return ssb.toString();
    }

}
