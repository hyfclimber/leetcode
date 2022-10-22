package leet;

import java.util.HashMap;

public class MostCommonPre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"aa","aa"};
		String pre = longestCommonPrefix(strs);
		System.out.println(pre);

	}

	
	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLentgh = 200;
        String minStr = "";
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (minLentgh > str.length()) {
            	minLentgh = str.length();
            	minStr = str;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLentgh; i++) {
        	boolean isCommon = true;
        	for (int j = 0; j < strs.length; j++) {
        		String str = strs[j];
        		if (minStr.charAt(i) != str.charAt(i)) {
        			isCommon = false;
        			break;
        		}
        	}
        	if (isCommon) {
        		sb.append(minStr.charAt(i));
        	} else {
        		break;
        	}
        	
        }
        return sb.toString();

    }
	
}
